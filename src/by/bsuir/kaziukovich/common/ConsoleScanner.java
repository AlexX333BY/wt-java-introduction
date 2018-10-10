package by.bsuir.kaziukovich.common;

import java.util.Scanner;

/**
 * Class to simplify getting data from console
 */
public class ConsoleScanner {
    /**
     * Console scanner object
     */
    private static final Scanner consoleScanner = new Scanner(System.in);

    /**
     * Get double value from console
     * @return First double value
     */
    public static double getDouble() {
        while (!consoleScanner.hasNextDouble()) {
            consoleScanner.next();
        }
        return consoleScanner.nextDouble();
    }

    /**
     * Get positive double value from console
     * @return First positive double value
     */
    public static double getPositiveDouble() {
        double result;

        do {
            result = getDouble();
        } while (result <= 0);
        return result;
    }

    /**
     * Get int value from console
     * @return First int value
     */
    public static int getInt() {
        while (!consoleScanner.hasNextInt()) {
            consoleScanner.next();
        }
        return consoleScanner.nextInt();
    }

    /**
     * Get non-negative int from console
     * @return First non-negative int value
     */
    public static int getNonNegativeInt() {
        int result;

        do {
            result = getInt();
        } while (result < 0);
        return result;
    }

    /**
     * Get first string from console
     * @return First string
     */
    public static String getString() {
        return consoleScanner.nextLine();
    }

    /**
     * Get first non-empty string from console
     * @return First non-empty string
     */
    public static String getNonEmptyString() {
        String result;

        do {
            result = getString();
        } while (result.isEmpty());
        return result;
    }

    /**
     * Constructor to avoid object creation
     */
    private ConsoleScanner() {}
}
