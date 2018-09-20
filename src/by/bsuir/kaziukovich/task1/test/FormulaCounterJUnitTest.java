package by.bsuir.kaziukovich.task1.test;

import by.bsuir.kaziukovich.task1.FormulaCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Random;

/**
 * Class containing tests for FormulaCounter class
 */
class FormulaCounterJUnitTest {
    /**
     * Method to test FormulaCounter.count() method
     */
    @Test
    void count() {
        int randomTestTimes = 10;
        Random random = new Random();
        double x, y;

        Assertions.assertEquals(0.5, FormulaCounter.count(0, 0));
        Assertions.assertEquals(-0.5, FormulaCounter.count(-1, 1));
        Assertions.assertEquals(1.0 / (4 - 4.0 / 17) + 2, FormulaCounter.count(2, -2));

        for (int randomTestNumber = 0; randomTestNumber < randomTestTimes; randomTestNumber++) {
            x = random.nextDouble();
            y = random.nextDouble();
            Assertions.assertFalse(FormulaCounter.count(x, y) < x);
        }
    }
}