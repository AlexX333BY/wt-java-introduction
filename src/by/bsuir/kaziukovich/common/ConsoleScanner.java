package by.bsuir.kaziukovich.common;

import java.util.Scanner;

/**
 * Class to simplify getting data from console
 */
public class ConsoleScanner {
    /**
     * Get double value from console
     * @return First double value
     */
    public static double getDouble() {
        Scanner consoleScanner = new Scanner(System.in);

        while (!consoleScanner.hasNextDouble()) {
            consoleScanner.next();
        }
        return consoleScanner.nextDouble();
    }

    /**
     * Constructor to avoid object creation
     */
    private ConsoleScanner() {}
}
