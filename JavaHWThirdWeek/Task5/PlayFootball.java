package Task5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;

/*
 * Друзья собираются каждый понедельник(10 сек - неделя) поиграть в футбол.
 * Если собирается 10 человек и на улице не идет дождь, матч проходит успешно,
 * иначе переносится на следующую неделю.
 */
public class PlayFootball  {
    protected static CountDownLatch START = new CountDownLatch(11);

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        while (true) {
            START = new CountDownLatch(11);
            try {
                for (int i = 0; i < (int) (Math.random() * 2 + 9); i++) {
                    new Thread(new Person(i+1)).start();
                    Thread.sleep(500);
                }

                if ((int) (Math.random() * 2) == 0){
                    System.out.println("Дождя нет");
                    START.countDown();
                }else{
                    System.out.println("Идет дождь.");
                }

                if(START.getCount() == 0){
                    System.out.println("Матч прошел успешно.\n");
                }else{
                    System.out.println("Матч перенесен на следующую неделю.\n");
                }
                Thread.sleep(10000);//ждем следующей недели

            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
    }
}
