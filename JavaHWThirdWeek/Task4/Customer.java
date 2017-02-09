package Task4;

public class Customer implements Runnable {
    private int number;

    Customer(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            //если в магазине перерыв, то завершаем поток
            if (JewelryShop.BREAK) {
                JewelryShop.SEMAPHORE.release();
                Thread.interrupted();
                System.out.printf("Покупатель %d покинул магазин.\n", number);
            }

            System.out.printf("Покупатель %d ожидает у магазина.\n", number);
            Thread.sleep(1000);
            JewelryShop.SEMAPHORE.acquire();
            int i;
            synchronized (JewelryShop.SHOP_PLACES) {
                for (i = 0; i < JewelryShop.SHOP_PLACES.length; i++) {
                    //если в магазине есть свободное место - пускаем посетителя
                    if (!JewelryShop.SHOP_PLACES[i]) {
                        JewelryShop.SHOP_PLACES[i] = true;
                        System.out.printf("Покупатель %d зашел в магазин.\n", number);

                        break;
                    }
                }

            }

            Thread.sleep((int) (Math.random() * 7000 + 1001));//посетитель находится в магазине 1-8 секунд
            JewelryShop.SHOP_PLACES[i] = false;//Освобождаем место
            JewelryShop.SEMAPHORE.release();
            System.out.printf("Покупатель %d покинул магазин.\n", number);

        } catch (InterruptedException e) {
            e.getMessage();
        }

    }
}
