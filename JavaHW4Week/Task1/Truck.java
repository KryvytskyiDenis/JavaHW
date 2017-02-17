package Task1;

//класс грузовика склада А
public class Truck implements Runnable {
    int numTruck;//номер грузовика
    int countTrip = 10;//кол-во поездок
    char currentPosition;//склад, на котором находится грузовик
    char targetPosition;//цель
    boolean isParcel = false;//соостояние погрузки посылки

    Truck(int numTruck, char currentPosition, char targetPosition) {
        this.numTruck = numTruck;
        this.currentPosition = currentPosition;
        this.targetPosition = targetPosition;
    }

    //метод отвечает за доставку груза, изменение положения грузовика и его поездки
    public void tripOfTruck(char targetPosition) throws InterruptedException {
        if (isParcel) {
            System.out.printf("Погрузка посылки на грузовик %d.\n", numTruck);
            Thread.sleep(2000);//погрузка

            System.out.printf("Посылка погружена на грузовик №%d. Грузовик отправился на склад %c\n", numTruck, targetPosition);
            Thread.sleep(1000);//путь до склада B - 1 секунда

            if (targetPosition == 'B') {
                StorageB.countParcel.getAndIncrement();//плюс одна посылка на складе B
                //меняем позиции местами
                currentPosition = 'B';
                this.targetPosition = 'A';
            } else {
                StorageA.countParcel.getAndIncrement();//плюс одна посылка на складе A
                currentPosition = 'A';
                this.targetPosition = 'B';
            }

            System.out.printf("Грузовик №%d прибыл на склад %c\n", numTruck, targetPosition);

            countTrip--;//-1 поездка грузовика
            isParcel = false;//опустошаем грузовик
        } else {
            System.out.printf("На складе %c посылок нет. Грузовик №%d ожидает.\n", currentPosition, numTruck);
        }
    }

    public void run() {
        Delivery.START.countDown();//уменьаем счетчик на один
        //ожидаем готовности остальных грузовиков
        try {
            Delivery.START.await();
            while (countTrip > 0) {

                //если находится на складе A и на нем есть посылка, то грузим посылку
                if (currentPosition == 'A') {
                    //если на складе есть посылки - забираем одну
                    synchronized (StorageA.class) {
                        if (StorageA.countParcel.get() != 0) {
                            StorageA.setCountParcel();//смотрим кол-во посылок на складе
                            StorageA.countParcel.getAndDecrement();//-1 посылка
                            isParcel = true;
                        }
                    }
                    tripOfTruck(targetPosition);
                } else if (currentPosition == 'B') {
                    //если на складе есть посылки - забираем одну
                    synchronized (StorageB.class) {
                        if (StorageB.countParcel.get() != 0) {
                            StorageB.setCountParcel();//смотрим кол-во посылок на складе
                            StorageB.countParcel.getAndDecrement();//смотрим кол-во посылок на складе
                            isParcel = true;
                        }
                    }

                    tripOfTruck(targetPosition);
                }

                Thread.sleep(2000);//ожидаем 2 секунды
            }
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}
