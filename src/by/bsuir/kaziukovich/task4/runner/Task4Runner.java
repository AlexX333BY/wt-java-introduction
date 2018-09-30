package by.bsuir.kaziukovich.task4.runner;

import by.bsuir.kaziukovich.common.ConsoleScanner;
import by.bsuir.kaziukovich.task4.primenumbers.PrimeNumbersDecisioner;
import java.util.ArrayList;

/**
 * Class to show task 4 implementation
 */
public class Task4Runner {
    /**
     * Entry point for program. Gets array from input and outputs result
     * @param args Console line arguments, not in use
     */
    public static void main(String[] args) {
        int[] array;
        ArrayList<Integer> indexes = new ArrayList<>();
        boolean hasPrimes;

        System.out.print("Enter array size: ");
        array = new int[ConsoleScanner.getNonNegativeInt()];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter " + (i + 1) + " element out of " + array.length + ": ");
            array[i] = ConsoleScanner.getInt();
        }

        hasPrimes = PrimeNumbersDecisioner.hasArrayPrimeNumbers(array, indexes);
        System.out.println("Inputted array has" + (hasPrimes ? "" : "n't any") + " prime numbers");
        if (hasPrimes) {
            String stringedIndexes = indexes.toString();

            System.out.println("Indexes of prime numbers: " + stringedIndexes.substring(1, stringedIndexes.length() - 1));
        }
    }

    /**
     * Constructor to avoid object creation
     */
    private Task4Runner() {}
}
