package by.bsuir.kaziukovich.task2.figure;

import java.util.Objects;

/**
 * Data structure to represent rectangle
 */
public class Rectangle {
    /**
     * Coordinates of rectangle's lower left corner
     */
    private Point lowerLeftCorner;

    /**
     * Height of rectangle
     */
    private int height;

    /**
     * Width of rectangle
     */
    private int width;

    /**
     * Returns lower left corner point
     * @return Lower left corner point
     */
    public Point getLowerLeftCorner() {
        return lowerLeftCorner;
    }

    /**
     * Sets lower left corner point
     * @param lowerLeftCorner Lower left corner point
     */
    public void setLowerLeftCorner(Point lowerLeftCorner) {
        if (lowerLeftCorner == null) {
            throw new IllegalArgumentException("Lower left corner shouldn't be null");
        }
        this.lowerLeftCorner = lowerLeftCorner;
    }

    /**
     * Returns height of rectangle
     * @return Height of rectangle
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets height of rectangle
     * @param height Height of rectangle
     */
    public void setHeight(int height) {
        if (height < 0) {
            throw new IllegalArgumentException("Rectangle height shouldn't be negative");
        }
        this.height = height;
    }

    /**
     * Returns width of rectangle
     * @return Width of rectangle
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets width of rectangle
     * @param width Width of rectangle
     */
    public void setWidth(int width) {
        if (width < 0) {
            throw new IllegalArgumentException("Rectangle width shouldn't be negative");
        }
        this.width = width;
    }

    /**
     * Checks if this object equals another object
     * @param o Object to check
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

        Rectangle rectangle = (Rectangle) o;
        return (height == rectangle.height) && (width == rectangle.width)
                && Objects.equals(lowerLeftCorner, rectangle.lowerLeftCorner);
    }

    /**
     * Returns hash code of object
     * @return Hash code of object
     */
    @Override
    public int hashCode() {
        return Objects.hash(lowerLeftCorner, height, width);
    }

    /**
     * Returns string representation of object
     * @return String representation of object
     */
    @Override
    public String toString() {
        return getClass().getName() + "@lowerLeftCorner: " + lowerLeftCorner + ", height: " + height + ", width: "
                + width;
    }

    /**
     * Constructor with initialization of all elements
     * @param lowerLeftCorner Lower left corner of rectangle
     * @param height Height of rectangle
     * @param width Width of rectangle
     */
    public Rectangle(Point lowerLeftCorner, int height, int width) {
        if (lowerLeftCorner == null) {
            throw new IllegalArgumentException("Lower left corner shouldn't be null");
        }
        if ((height < 0) || (width < 0)) {
            throw new IllegalArgumentException("Rectangle dimensions shouldn't be negative");
        }

        this.lowerLeftCorner = lowerLeftCorner;
        this.height = height;
        this.width = width;
    }
}
