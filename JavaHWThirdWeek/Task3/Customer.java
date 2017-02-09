package Task3;

import java.util.concurrent.BrokenBarrierException;

public class Customer implements Runnable {
    private int number;

    Customer(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            //+1 посетитель возле салона
            System.out.printf("Покупатель %d возле салона.\n", number);
            CarShowroom.CUSTOMERREADY.countDown();
            //ждем еще посетителей
            CarShowroom.CUSTOMERREADY.await();
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}
