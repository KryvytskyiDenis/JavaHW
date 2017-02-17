import Task3.Calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void testCalcSum() throws Exception {
        Calculator calculator = new Calculator();
        int n = calculator.calcSum(3, 2);

        assertEquals(5, n);
    }

    @Test
    public void testCalcSub() throws Exception {
        Calculator calculator = new Calculator();
        int n = calculator.calcSub(10, 5);

        assertEquals(5, n);
    }

    @Test
    public void testCalcDiv() throws Exception {
        Calculator calculator = new Calculator();
        int n = calculator.calcDiv(125, 5);

        assertEquals(25, n);
    }

    @Test
    public void testCalcProduct() throws Exception {
        Calculator calculator = new Calculator();
        int n = calculator.clacProduct(5, 10);

        assertEquals(50, n);
    }
}
