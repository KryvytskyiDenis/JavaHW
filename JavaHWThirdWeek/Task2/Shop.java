package Task2;

import java.util.ArrayList;

public class Shop implements Runnable {
    private int number;//номер магазина
    private int timeSale;//время продажи

    ArrayList<Apple> apples = new ArrayList<>();//список-массив яблок

    Shop(int number, int timeSale) {
        this.number = number;
        this.timeSale = timeSale;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (apples.isEmpty()) {
                    System.out.printf("Магазин №%d пуст.\n", number);
                    System.out.printf("Магазин №%d отправил грузовик на склад.\n", number);
                    Thread.sleep(1000);
                    synchronized (apples) {
                        apples = Stock.EXCHANGER.exchange(apples);
                        System.out.printf("Магазин №%d получил партию яблок.\n", number);
                    }
                } else {
                    for (int i = 0; i < apples.size(); i++) {
                        System.out.println("Магазин №" + number + " продал: " + apples.remove(i));
                        Thread.sleep(timeSale);//продажа в два раза быстрей у первого магазина
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
