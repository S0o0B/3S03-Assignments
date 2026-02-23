package calculator;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void divide_normalCase_returnsQuotient() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.divide(10, 2));
    }

    @Test(expected = ArithmeticException.class)
    public void divide_byZero_throwsException() {
        Calculator calc = new Calculator();
        calc.divide(10, 0);
    }

    @Test
    public void divide_zeroNumerator_returnsZero() {
        Calculator calc = new Calculator();
        assertEquals(0, calc.divide(0, 5));
    }

    @Test
    public void divide_negativeNumbers_returnsCorrectSign() {
        Calculator calc = new Calculator();
        assertEquals(-4, calc.divide(-8, 2));
        assertEquals(-4, calc.divide(8, -2));
        assertEquals(4, calc.divide(-8, -2));
    }

    @Test
    public void divide_nonEvenDivision_stillIntegerDivision() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.divide(5, 2)); // documents current semantics
    }
    
    @Test
    public void divide_decimalDivision_returnsDecimalResult() {
        Calculator calc = new Calculator();
        assertEquals(2.5, calc.divide(5.0, 2.0), 0.000001);
    }
}