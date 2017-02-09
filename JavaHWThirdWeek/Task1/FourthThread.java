package Task1;

public class FourthThread implements Runnable {

    @Override
    public void run() {
        try {
            Main.START4.await();
            System.out.println("Стартовал 4-й поток.");
            Thread.sleep((int) (Math.random() * 3001));
            System.out.println("Завершился 4-й поток.");
            System.out.println();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}