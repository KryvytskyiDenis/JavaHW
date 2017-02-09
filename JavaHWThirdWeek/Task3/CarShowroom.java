package Task3;

import java.util.concurrent.CountDownLatch;

/*
 * В автосалоне аукцион.
 * Условием начала аукциона является наличие 5 автомобилей в салоне, также 10 покупателей возле магазина.
 */
public class CarShowroom {
    protected static final CountDownLatch CUSTOMERREADY = new CountDownLatch(15);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            if (i <= 5) {
                new Thread(new Car(i)).start();
                Thread.sleep(500);
            }
            new Thread(new Customer(i)).start();
            Thread.sleep(500);
        }

        while (CUSTOMERREADY.getCount() != 0) {
            //ожидаем выполнение условия
            Thread.sleep(1000);
        }

        //условия выполнены, можно начинать аукцион
        System.out.println("Аукцион открыт!!!");
    }
}
