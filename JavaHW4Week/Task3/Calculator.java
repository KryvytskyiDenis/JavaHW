package Task3;

public class Calculator {
    private int a, b;

    public Calculator() {
    }

    Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int calcSum(int a, int b) {
        return a + b;
    }

    public int calcSub(int a, int b) {
        return a - b;
    }

    public int calcDiv(int a, int b) {
        return a / b;
    }

    public int clacProduct(int a, int b) {
        return a * b;
    }
}
