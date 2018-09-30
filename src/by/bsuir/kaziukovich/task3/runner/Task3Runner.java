package by.bsuir.kaziukovich.task3.runner;

import by.bsuir.kaziukovich.common.ConsoleScanner;
import by.bsuir.kaziukovich.task3.tangent.StepTangentCounter;
import by.bsuir.kaziukovich.task3.tablebuilder.TwoColumnTableBuilder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Runner to demonstrate task 3 implementation
 */
public class Task3Runner {
    /**
     * Entry point for class. Gets bounds and step and outputs table
     * @param args Command line arguments, not used
     */
    public static void main(String[] args) {
        double leftBound, rightBound;
        double step;
        Map<Double, Double> result;

        System.out.println("Enter bounds");
        System.out.print("Enter left bound: ");
        leftBound = ConsoleScanner.getDouble();
        System.out.print("Enter right bound: ");
        rightBound = ConsoleScanner.getDouble();
        System.out.print("Enter step: ");
        step = ConsoleScanner.getDouble();

        try {
            result = StepTangentCounter.count(leftBound, rightBound, step);
            System.out.println(TwoColumnTableBuilder.build(new LinkedHashMap<>(result), "x", "tg(x)"));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Constructor to avoid object creation
     */
    private Task3Runner() {}
}
