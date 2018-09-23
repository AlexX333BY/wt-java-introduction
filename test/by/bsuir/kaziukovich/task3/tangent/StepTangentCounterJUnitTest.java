package by.bsuir.kaziukovich.task3.tangent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for StepTangentCounter class
 */
class StepTangentCounterJUnitTest {
    /**
     * Tests for count() method
     */
    @Test
    void count() {
        Assertions.assertEquals(1, StepTangentCounter.count(0, 0, 0.1).size());
        Assertions.assertEquals(11, StepTangentCounter.count(0, 1, 0.1).size());

        /* tg(0) == 0 */
        Assertions.assertEquals(new Double(0), StepTangentCounter.count(0, 0, 0.1).get((double) 0));

        /* tg(PI / 2) == Inf */
        Assertions.assertEquals(new Double(Double.POSITIVE_INFINITY), StepTangentCounter.count(Math.PI / 2, Math.PI / 2, 0.1).get(Math.PI / 2));

        Assertions.assertThrows(IllegalArgumentException.class, () -> StepTangentCounter.count(1, -1, 0.1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> StepTangentCounter.count(-1, 1, -0.1));
    }
}