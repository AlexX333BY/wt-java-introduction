package by.bsuir.kaziukovich.task6.squarematrix;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Class containing methods for creating square matrix by array
 */
public class SquareMatrixGenerator {
    /**
     * Converts double array to ArrayList
     * @param array Array to convert
     * @return Converted ArrayList
     */
    private static ArrayList<Double> doubleArrayToList(double[] array) {
        ArrayList<Double> list = new ArrayList<>();

        if (array == null) {
            throw new IllegalArgumentException("Array shouldn't be null");
        }

        for (double number : array) {
            list.add(number);
        }
        return list;
    }

    /**
     * Generate square matrix by array
     * @param array Array to generate by
     * @return Generated matrix
     */
    public static double[][] generate(double[] array) {
        List<Double> list;
        ListIterator<Double> iterator;
        double[][] result;

        if (array == null) {
            throw new IllegalArgumentException("Array of elements shouldn't be null");
        }
        if (array.length == 0) {
            return new double[0][0];
        }

        list = doubleArrayToList(array);
        iterator = list.listIterator();
        result = new double[array.length][array.length];

        for (double[] subArray : result) {
            for (int index = 0; index < subArray.length; index++) {
                if (!iterator.hasNext()) {
                    iterator = list.listIterator();
                }
                subArray[index] = iterator.next();
            }
            if (!iterator.hasNext()) {
                iterator = list.listIterator();
            }
            iterator.next();
        }
        return result;
    }

    /**
     * Private constructor to prevent object creation
     */
    private SquareMatrixGenerator() {}
}
