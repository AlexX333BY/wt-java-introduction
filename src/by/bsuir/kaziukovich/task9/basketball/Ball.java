package by.bsuir.kaziukovich.task9.basketball;

import java.util.Objects;

/**
 * Class describing Ball with weight property
 */
public final class Ball {
    /**
     * Weight of ball
     */
    private final double weight;

    /**
     * Color of ball
     */
    private final String color;

    /**
     * Get ball's weight
     * @return Ball's weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gets ball's color
     * @return Ball's color
     */
    public String getColor() {
        return color;
    }

    /**
     * Compares this object to argument
     * @param o Object to compare
     * @return True if objects are same, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        Ball ball;

        if (this == o) {
            return true;
        }
        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }

        ball = (Ball) o;
        return (ball.weight == weight) && Objects.equals(ball.color, color);
    }

    /**
     * Generates hashcode of this object
     * @return Hash code of this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(weight, color);
    }

    /**
     * Generates string representation of this object
     * @return String representation of this object
     */
    @Override
    public String toString() {
        return getClass().getName() + "@weight: " + weight + ", color: " + color;
    }

    /**
     * Constructor for Ball
     * @param weight Weight of ball. Should be positive finite number
     */
    public Ball(double weight, String color) {
        if (!Double.isFinite(weight)) {
            throw new IllegalArgumentException("Weight should be finite");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight should be positive");
        }
        if ((color == null) || color.isEmpty()) {
            throw new IllegalArgumentException("Ball should have color");
        }

        this.weight = weight;
        this.color = color;
    }
}
