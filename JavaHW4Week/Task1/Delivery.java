package Task1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Delivery {
    //счетчик уменьшается на 1, когда +1 грузовик готов
    static protected CountDownLatch START = new CountDownLatch(16);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService trucksA = Executors.newFixedThreadPool(5);//пять грузовиков
        ExecutorService trucksB = Executors.newFixedThreadPool(10);//десять грузовиков


        //начинаем работу складов
        for (int i = 1; i <= 5; i++) {
            trucksA.submit(new Truck(i, 'A', 'B'));
        }

        for (int i = 1; i <= 10; i++) {
            trucksB.submit(new Truck(i+5, 'B', 'A'));
        }

        while(START.getCount() > 1){
            System.out.println("Ожидаем грузовики.");
            Thread.sleep(100);
        }

        //грузовики готовы, можно начинать работу складов
        START.countDown();
    }
}
