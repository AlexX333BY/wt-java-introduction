package by.bsuir.kaziukovich.task9.basketanalysis;

import by.bsuir.kaziukovich.task9.basketball.Ball;
import by.bsuir.kaziukovich.task9.basketball.Basket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for BasketAnalyzer class
 */
class BasketAnalyzerJUnitTest {
    /**
     * Tests for getBallsWeight() method
     */
    @Test
    void getBallsWeight() {
        Basket basket = new Basket();
        Ball ball1 = new Ball(1, "red"), ball2 = new Ball(2, "green");

        Assertions.assertThrows(IllegalArgumentException.class, () -> BasketAnalyzer.getBallsWeight(null));
        Assertions.assertEquals(0, BasketAnalyzer.getBallsWeight(basket));
        basket.addBall(ball1);
        basket.addBall(ball2);
        Assertions.assertEquals(ball1.getWeight() + ball2.getWeight(), BasketAnalyzer.getBallsWeight(basket));
    }

    /**
     * Tests for getBallsByColor() method
     */
    @Test
    void getBallsByColor() {
        Basket basket = new Basket();

        Assertions.assertThrows(IllegalArgumentException.class, () -> BasketAnalyzer.getBallsByColor(null, "color"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> BasketAnalyzer.getBallsByColor(basket, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> BasketAnalyzer.getBallsByColor(basket, ""));

        basket.addBall(new Ball(1, "red"));
        basket.addBall(new Ball(1, "red"));
        basket.addBall(new Ball(2, "red"));
        basket.addBall(new Ball(2, "blue"));
        basket.addBall(new Ball(3, "blue"));

        Assertions.assertEquals(3, BasketAnalyzer.getBallsByColor(basket, "red").size());
        Assertions.assertEquals(2, BasketAnalyzer.getBallsByColor(basket, "blue").size());
        Assertions.assertEquals(0, BasketAnalyzer.getBallsByColor(basket, "green").size());
    }
}