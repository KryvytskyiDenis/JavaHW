package Task3;

public class Car implements Runnable {
    private int number;

    Car(int number) {
        this.number = number;
    }

    @Override
    public void run() {

        System.out.printf("Автомобиль %d прибыл на аукцион.\n", number);
        //+1 автомобиль на аукционе
        //уменьшаем счетчик
        CarShowroom.CUSTOMERREADY.countDown();

    }
}
