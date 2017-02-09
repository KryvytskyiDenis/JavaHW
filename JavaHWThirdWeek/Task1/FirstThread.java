package Task1;

public class FirstThread implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Стартовал 1-й поток.");
            Thread.sleep((int) (Math.random() * 3001));
            System.out.println("Завершился 1-й поток.");
            Main.START23.countDown();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}