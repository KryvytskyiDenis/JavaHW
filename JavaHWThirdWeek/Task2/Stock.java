package Task2;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class Stock implements Runnable {
    static final Exchanger<ArrayList<Apple>> EXCHANGER = new Exchanger<>();
    private static final Semaphore SEMAPHORE = new Semaphore(1, true);

    ArrayList<Apple> apples = new ArrayList<>();

    Stock() {
        //добавляем яблоки
        addApples();
    }

    //метод добавляет яблоки на склад(организация поставщика)
    public void addApples() {
        Random rand = new Random();
        apples.add(new Apple("Akava", rand.nextInt(300)));
        apples.add(new Apple("Jonathan", rand.nextInt(300)));
        apples.add(new Apple("GoldenDel", rand.nextInt(300)));
        apples.add(new Apple("RedDel", rand.nextInt(300)));
        apples.add(new Apple("Winesap", rand.nextInt(300)));
        apples.add(new Apple("McIntosh", rand.nextInt(300)));
        apples.add(new Apple("Antonovka", rand.nextInt(300)));
        apples.add(new Apple("Cameo", rand.nextInt(300)));
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (apples.isEmpty()) {
                    System.out.println("Склад пуст, ждем поставщика.");
                    Thread.sleep(3000);
                    addApples();//получаем яблоки
                } else {
                    //передаем яблоки магазину
                    apples = EXCHANGER.exchange(apples);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Stock()).start();
        new Thread(new Shop(1, 1000)).start();
        new Thread(new Shop(2, 2000)).start();
    }
}
