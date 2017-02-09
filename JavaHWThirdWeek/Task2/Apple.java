package Task2;

public class Apple {
    private String cultivar;
    private int count;

    Apple(String cultivar, int count) {
        this.cultivar = cultivar;
        this.count = count;
    }

    @Override
    public String toString() {
        return this.count + " яблок " + this.cultivar + " сорта.";
    }
}
