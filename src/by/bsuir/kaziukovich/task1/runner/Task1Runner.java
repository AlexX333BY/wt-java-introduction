package by.bsuir.kaziukovich.task1.runner;

import by.bsuir.kaziukovich.ConsoleScanner;
import by.bsuir.kaziukovich.task1.FormulaCounter;

/**
 * Runner to demonstrate task 1 completion
 */
public class Task1Runner {
    /**
     * Entry point for class. Gets two variables and outputs formula result
     * @param args Command line arguments, not used
     */
    public static void main(String[] args) {
        double x, y;
        double formulaResult;

        System.out.println("Print two values");
        System.out.print("Print x: ");
        x = ConsoleScanner.getDouble();
        System.out.print("Print y: ");
        y = ConsoleScanner.getDouble();

        try {
            formulaResult = FormulaCounter.count(x, y);
            System.out.println("Formula result with x = " + x + " and y = " + y + " is " + formulaResult);
        } catch (ArithmeticException arithmeticException) {
            System.out.println("Error caused by specified x and y: " + arithmeticException.getMessage());
        }
    }

    private Task1Runner() {}
}
