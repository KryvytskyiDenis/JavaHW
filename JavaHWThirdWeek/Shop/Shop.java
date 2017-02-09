package Shop;

import java.util.concurrent.CountDownLatch;

public class Shop {

    protected static final CountDownLatch START = new CountDownLatch(4);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 3; i++) {
            new Thread(new Customer(i)).start();
            System.out.println("Покупатель " + i + " ждет.");
            Thread.sleep(1000);
        }

        Thread.sleep(1000);
        System.out.println("Менеджер приглашает войти.");
        Thread.sleep(1000);
        START.countDown();
    }

}
