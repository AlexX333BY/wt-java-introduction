package by.bsuir.kaziukovich.task2.runner;

import by.bsuir.kaziukovich.common.ConsoleScanner;
import by.bsuir.kaziukovich.task2.figure.Point;
import by.bsuir.kaziukovich.task2.decisioner.PointInFigureDecisioner;
import by.bsuir.kaziukovich.task2.figure.Rectangle;

/**
 * Class to demonstrate implementation of task 2
 */
public class Task2Runner {
    /**
     * Gets point coordinates from console and returns constructed point
     * @return Constructed point
     */
    private static Point getPointFromInput() {
        int x, y;

        System.out.print("Enter x: ");
        x = ConsoleScanner.getInt();
        System.out.print("Enter y: ");
        y = ConsoleScanner.getInt();

        return new Point(x, y);
    }

    /**
     * Gets rectangle dimensions from input and returns constructed rectangle
     * @return Constructed rectangle
     */
    private static Rectangle getRectangleFromInput() {
        Rectangle rectangle = null;     // initialization with null to allow return
        int height, width;
        Point lowerLeftPoint;
        boolean isInputCorrect;

        System.out.println("Enter lower left corner point of rectangle");
        lowerLeftPoint = getPointFromInput();

        do {
            isInputCorrect = true;
            System.out.print("Enter rectangle height: ");
            height = ConsoleScanner.getInt();
            System.out.print("Enter rectangle width: ");
            width = ConsoleScanner.getInt();

            try {
                rectangle = new Rectangle(lowerLeftPoint, height, width);
            } catch (IllegalArgumentException e) {
                System.out.println("Error while inputting: " + e.getMessage());
                isInputCorrect = false;
            }
        } while (!isInputCorrect);

        return rectangle;
    }

    /**
     * Entry point for class. Gets dimensions of figure, coordinates of point and outputs if point in figure
     * @param args Command line arguments, not used
     */
    public static void main(String[] args) {
        Point point;
        Rectangle upperRectangle, lowerRectangle;

        System.out.println("Enter point to check");
        point = getPointFromInput();

        System.out.println("Enter upper rectangle of figure");
        upperRectangle = getRectangleFromInput();
        System.out.println("Enter lower rectangle of figure");
        lowerRectangle = getRectangleFromInput();

        try {
            System.out.println("Point is in figure: " + PointInFigureDecisioner.isPointInFigure(point, upperRectangle,
                    lowerRectangle));
        } catch (IllegalArgumentException e) {
            System.out.println("Error while decisioning: " + e.getMessage());
        }
    }

    /**
     * Constructor to avoid object creation
     */
    private Task2Runner() {}
}
