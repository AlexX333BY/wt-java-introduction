package by.bsuir.kaziukovich.task9.basketball;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Class describing Basket
 */
public final class Basket {
    /**
     * Balls of Basket
     */
    private LinkedList<Ball> balls;

    /**
     * Adds ball to basket
     * @param ball Ball to add
     */
    public void addBall(Ball ball) {
        if (ball == null) {
            throw new IllegalArgumentException("Ball shouldn't be null");
        }

        balls.add(ball);
    }

    /**
     * Returns last ball of basket and removes it
     * @return Last ball of basket and removes it, or null if basket is empty
     */
    public Ball popBall() {
        return balls.pollLast();
    }

    /**
     * Removes all balls from basket
     */
    public void emptyBasket() {
        balls.clear();
    }

    /**
     * Checks if basket is empty
     * @return True if basket is empty, otherwise false
     */
    public boolean isEmpty() {
        return getBallsCount() == 0;
    }

    /**
     * Gets amount of balls in basket
     * @return Amount of balls in basket
     */
    public int getBallsCount() {
        return balls.size();
    }

    /**
     * Gets all balls of basket
     * @return All balls of basket
     */
    public ArrayList<Ball> getBalls() {
        return new ArrayList<>(balls);
    }

    /**
     * Compares this object to argument
     * @param o Object to compare
     * @return True if objects are same, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }

        return Objects.equals(balls, ((Basket) o).balls);
    }

    /**
     * Generates hashcode of this object
     * @return Hash code of this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }

    /**
     * Generates string representation of this object
     * @return String representation of this object
     */
    @Override
    public String toString() {
        return getClass().getName() + "@balls: " + balls.toString();
    }

    /**
     * Constructor for Basket
     */
    public Basket() {
        balls = new LinkedList<>();
    }
}
