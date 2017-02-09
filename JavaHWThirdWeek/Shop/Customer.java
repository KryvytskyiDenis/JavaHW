package Shop;

public class Customer implements Runnable {
    private int numCustomer;

    public Customer(int numCustomer) {
        this.numCustomer = numCustomer;
    }

    public void run() {

        try {
            Shop.START.countDown();
            Shop.START.await();

            System.out.println("Покупатель " + numCustomer + " зашел.");
        } catch (Exception e) {
            e.getCause();
        }
    }

}