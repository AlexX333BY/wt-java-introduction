package by.bsuir.kaziukovich.task9.basketball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Tests for Basket class
 */
class BasketJUnitTest {
    /**
     * Tests for addBall() method
     */
    @Test
    void addBall() {
        Basket basket = new Basket();

        basket.addBall(new Ball(1, "red"));
        Assertions.assertEquals(1, basket.getBallsCount());
        basket.addBall(new Ball(2, "green"));
        Assertions.assertEquals(2, basket.getBallsCount());
    }

    /**
     * Tests for popBall() method
     */
    @Test
    void popBall() {
        Basket basket = new Basket();
        Ball ball = new Ball(4.2, "blue");

        basket.addBall(ball);
        Assertions.assertEquals(ball, basket.popBall());
        Assertions.assertTrue(basket.isEmpty());
    }

    /**
     * Tests for emptyBasket() method
     */
    @Test
    void emptyBasket() {
        Basket basket = new Basket();

        basket.addBall(new Ball(4.2, "red"));
        Assertions.assertFalse(basket.isEmpty());
        basket.emptyBasket();
        Assertions.assertTrue(basket.isEmpty());
    }

    /**
     * Tests for isEmpty() method
     */
    @Test
    void isEmpty() {
        Basket basket = new Basket();

        Assertions.assertTrue(basket.isEmpty());
        basket.addBall(new Ball(4.2, "red"));
        Assertions.assertFalse(basket.isEmpty());
    }

    /**
     * Tests for getBallsCount() method
     */
    @Test
    void getBallsCount() {
        Basket basket = new Basket();

        Assertions.assertEquals(0, basket.getBallsCount());
        basket.addBall(new Ball(1, "red"));
        Assertions.assertEquals(1, basket.getBallsCount());
        basket.addBall(new Ball(2, "green"));
        Assertions.assertEquals(2, basket.getBallsCount());
    }

    /**
     * Tests for getBalls() method
     */
    @Test
    void getBalls() {
        Basket basket = new Basket();
        Ball ball1 = new Ball(1, "red"), ball2 = new Ball(2, "green");
        ArrayList<Ball> balls = new ArrayList<>();

        balls.add(ball1);
        balls.add(ball2);

        Assertions.assertEquals(0, basket.getBalls().size());
        basket.addBall(ball1);
        basket.addBall(ball2);
        Assertions.assertEquals(balls, basket.getBalls());
    }
}