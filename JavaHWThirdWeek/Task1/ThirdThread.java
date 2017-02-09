package Task1;

public class ThirdThread implements Runnable {

    @Override
    public void run() {
        try {
            Main.START23.await();
            System.out.println("Стартовал 3-й поток.");
            Thread.sleep((int) (Math.random() * 3001));
            System.out.println("Завершился 3-й поток.");
            Main.START4.countDown();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}