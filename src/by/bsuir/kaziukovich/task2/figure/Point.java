package by.bsuir.kaziukovich.task2.figure;

import java.util.Objects;

/**
 * Data structure to describe 2D point
 */
public class Point {
    /**
     * Field for x coordinate
     */
    private int x;

    /**
     * Field for y coordinate
     */
    private int y;

    /**
     * Sets incapsulated x field
     * @param x x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets incapsulated y field
     * @param y y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets incapsulated x field
     * @return x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Gets incapsulated y field
     * @return y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Compares this object with function argument
     * @param o Object to compare with
     * @return True if objects are same, else false
     */
    @Override
    public boolean equals(Object o) {
        Point point;

        if (this == o) {
            return true;
        }

        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }

        point = (Point) o;
        return (x == point.x) && (y == point.y);
    }

    /**
     * Counts hash code of object
     * @return Hash code of object
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Creates string representation of object
     * @return String representation of object
     */
    @Override
    public String toString() {
        return getClass().getName() + "@x: " + x + ", y: " + y;
    }

    /**
     * Constructor with x and y init params
     * @param x x coordinate
     * @param y y coordinate
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
