package by.bsuir.kaziukovich.task2.figure;

/**
 * Class containing methods to decide if point is in figure
 */
public class PointInFigureDecisioner {
    /**
     * Method decides if point is in rectangle
     * @param point Point to check
     * @param rectangle Rectangle to check
     * @return True if point is in rectangle, otherwise false
     */
    private static boolean isPointInRectangle(Point point, Rectangle rectangle) {
        if ((point == null) || (rectangle == null)) {
            throw new IllegalArgumentException("Arguments shouldn't be null");
        }

        return (point.getX() >= rectangle.getLowerLeftCorner().getX())
                && (point.getY() >= rectangle.getLowerLeftCorner().getY())
                && (point.getX() <= (rectangle.getLowerLeftCorner().getX() + rectangle.getWidth()))
                && (point.getY() <= (rectangle.getLowerLeftCorner().getY() + rectangle.getHeight()));
    }

    /**
     * Method decides if point is in figure
     * @param point Point to check
     * @param upperRectangle Upper rectangle of figure
     * @param lowerRectangle Lower rectangle of figure
     * @return True if point is in figure, otherwise false
     */
    public static boolean isPointInFigure(Point point, Rectangle upperRectangle, Rectangle lowerRectangle) {
        if ((point == null) || (upperRectangle == null) || (lowerRectangle == null)) {
            throw new IllegalArgumentException("Arguments shouldn't be null");
        }
        if (upperRectangle.getLowerLeftCorner().getY() < lowerRectangle.getLowerLeftCorner().getY()) {
            throw  new IllegalArgumentException("Rectangles don't match their names");
        }

        return isPointInRectangle(point, upperRectangle) || isPointInRectangle(point, lowerRectangle);
    }

    /**
     * Empty constructor to prevent object creation
     */
    private PointInFigureDecisioner() {}
}
