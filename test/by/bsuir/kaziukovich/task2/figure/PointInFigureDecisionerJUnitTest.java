package by.bsuir.kaziukovich.task2.figure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class containing tests for PointFigureDecisioner class
 */
class PointInFigureDecisionerJUnitTest {
    /**
     * Tests for isPointInFigure() method
     */
    @Test
    void isPointInFigure() {
        /* example from task */
        Rectangle upperRectangle = new Rectangle(new Point(-4, 0), 5, 8);
        Rectangle lowerRectangle = new Rectangle(new Point(-6, -3), 3, 12);

        Assertions.assertTrue(PointInFigureDecisioner.isPointInFigure(new Point(0, 0), upperRectangle,
                lowerRectangle));
        Assertions.assertTrue(PointInFigureDecisioner.isPointInFigure(new Point(-6, -3), upperRectangle,
                lowerRectangle));
        Assertions.assertTrue(PointInFigureDecisioner.isPointInFigure(new Point(4, 5), upperRectangle,
                lowerRectangle));

        Assertions.assertFalse(PointInFigureDecisioner.isPointInFigure(new Point(42, 42), upperRectangle,
                lowerRectangle));

        /* attempt to swap figure */
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> PointInFigureDecisioner.isPointInFigure(new Point(42, 42), lowerRectangle, upperRectangle));
    }
}