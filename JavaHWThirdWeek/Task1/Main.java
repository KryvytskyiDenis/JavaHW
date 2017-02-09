package Task1;

import java.util.concurrent.CountDownLatch;

/*
 * Стартует первый поток(1), после завершения выполнения первого потока стартуют одновременно два потока(2 и 3).
 * После завершения потоков 2 и 3(в зависимости от того кто завершит свое выполнение последний) стартует 4 поток.
 * Время выполнения каждого потока каждый раз разное
 */
public class Main {
    protected static final CountDownLatch START23 = new CountDownLatch(1);
    protected static final CountDownLatch START4 = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new FirstThread()).start();
        new Thread(new SecondThread()).start();
        new Thread(new ThirdThread()).start();
        new Thread(new FourthThread()).start();

    }
}
