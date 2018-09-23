package by.bsuir.kaziukovich.task6.runner;

import by.bsuir.kaziukovich.common.ConsoleScanner;
import by.bsuir.kaziukovich.task6.squarematrix.SquareMatrixGenerator;

/**
 * Runner class to demonstrate task 6 implementation
 */
public class Task6Runner {
    /**
     * Entry point for demonstration program
     * @param args Command line arguments, not in use
     */
    public static void main(String[] args) {
        double[] inputArray;
        StringBuilder stringBuilder = new StringBuilder();

        System.out.print("Enter source array length: ");
        inputArray = new double[ConsoleScanner.getNonNegativeInt()];
        for (int index = 0; index < inputArray.length; index++) {
            System.out.print("Enter number " + (index + 1) + " of " + inputArray.length + ": ");
            inputArray[index] = ConsoleScanner.getDouble();
        }

        for (double[] subArray : SquareMatrixGenerator.generate(inputArray)) {
            for (double value : subArray) {
                stringBuilder.append(value);
                stringBuilder.append(' ');
            }
            stringBuilder.append('\n');
        }
        System.out.println("Result matrix:");
        System.out.println(stringBuilder.toString());
    }

    /**
     * Private constructor to prevent object creation
     */
    private Task6Runner() {}
}
