package by.bsuir.kaziukovich.task7.runner;

import by.bsuir.kaziukovich.common.ConsoleScanner;
import by.bsuir.kaziukovich.task7.shellsort.ShellSort;

/**
 * Class to demonstrate task 7 implementation
 */
public class Task7Runner {
    /**
     * Entry point for program. Inputs array and outputs sorted array
     * @param args Command line arguments, not in use
     */
    public static void main(String[] args) {
        double[] array;
        StringBuilder stringBuilder = new StringBuilder();

        System.out.print("Enter array length: ");
        array = new double[ConsoleScanner.getNonNegativeInt()];
        for (int index = 0; index < array.length; index++) {
            System.out.print("Enter number " + (index + 1) + " of " + array.length + ": ");
            array[index] = ConsoleScanner.getDouble();
        }

        ShellSort.sort(array);

        for (double value : array) {
            stringBuilder.append(value);
            stringBuilder.append(", ");
        }
        System.out.print("Sorted array: " + stringBuilder.toString());
    }

    /**
     * Constructor to avoid object creation
     */
    private Task7Runner() {}
}
