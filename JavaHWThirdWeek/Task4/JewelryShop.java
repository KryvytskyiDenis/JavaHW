package Task4;

import java.util.concurrent.Semaphore;

/*
 * Задача про ювелирный магазин
 */
public class JewelryShop {
    //В магазине нету свободных мест - true, есть свободное место - false
    protected static final boolean[] SHOP_PLACES = new boolean[5];

    //aсquire() будет раздавать разрешения в порядке очереди
    protected static final Semaphore SEMAPHORE = new Semaphore(5, true);
    protected static boolean BREAK = false;

    public static void main(String[] args) throws InterruptedException {

        int numCustomer = 1;//номер покупателя

        while (true) {
            //создаем 5 потоков - покупателей
            for (int i = 1; i <= 5; i++) {
                new Thread(new Customer(numCustomer++)).start();
                Thread.sleep(500);
            }
            //если в магазине меньше 4 покупателй, то объявляем перерыв. При этом покупатели выходят из магазина
            if (SEMAPHORE.availablePermits() > 2) {
                BREAK = true;
                Thread.sleep(2000);//ожидаем пока покупатели выйдут из магазина
                System.out.println("Перерыв!!!");
                Thread.sleep(10000);//если покупателей меньше 4, то перерыв на 10 секунд
            }
        }
    }
}
