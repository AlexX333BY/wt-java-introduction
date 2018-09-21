package by.bsuir.kaziukovich.task1.formula;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class containing tests for FormulaCounter class
 */
class FormulaCounterJUnitTest {
    /**
     * Method to test FormulaCounter.count() method
     */
    @Test
    void count() {
        Assertions.assertEquals(0.5, FormulaCounter.count(0, 0));
        Assertions.assertEquals(-0.5, FormulaCounter.count(-1, 1));
        Assertions.assertEquals(1.0 / (4 - 4.0 / 17) + 2, FormulaCounter.count(2, -2));

        /* result of formula should be NaN, so method will throw an exception */
        Assertions.assertThrows(ArithmeticException.class,
                () -> FormulaCounter.count(Double.MAX_VALUE, Double.MAX_VALUE));
    }
}