package by.bsuir.kaziukovich.task9.basketball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for Ball class
 */
class BallJUnitTest {
    /**
     * Tests for Ball object construction
     */
    @Test
    void construction() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ball(0, "somecolor"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ball(42, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ball(43, ""));
    }

    /**
     * Tests for getWeight() method
     */
    @Test
    void getWeight() {
        double weight = 3.8;

        Assertions.assertEquals(weight, new Ball(weight, "blue").getWeight());
    }

    /**
     * Tests for getColor() method
     */
    @Test
    void getColor() {
        String color = "red";

        Assertions.assertEquals(color, new Ball(42, color).getColor());
    }
}