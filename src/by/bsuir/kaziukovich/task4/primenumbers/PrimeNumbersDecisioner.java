package by.bsuir.kaziukovich.task4.primenumbers;

import java.util.List;

/**
 * Class containing methods to decide whether array has prime numbers
 */
public class PrimeNumbersDecisioner {
    /**
     * Method decides whether number is prime
     * @param number Number to check
     * @return True if number is prime, otherwise false
     */
    private static boolean isPrime(int number) {
        int rightBound = (int) Math.sqrt(number);

        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= rightBound; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method decides whether array contains prime numbers
     * @param array Array to check
     * @param primeNumbersIndexes List that will be filled with prime numbers indexes. If parameter is null, method will
     *                            only decide if array contains prime numbers without saving theirs indexes
     * @return True if array contains any prime numbers, otherwise false
     */
    public static boolean hasArrayPrimeNumbers(int[] array, List<Integer> primeNumbersIndexes) {
        boolean hasPrimes = false;

        if (array == null) {
            throw new IllegalArgumentException("Array shouldn't be null");
        }

        for (int index = 0; index < array.length; index++) {
            if (isPrime(array[index])) {
                hasPrimes = true;
                if (primeNumbersIndexes == null) {
                    break;
                } else {
                    primeNumbersIndexes.add(index);
                }
            }
        }
        return hasPrimes;
    }

    /**
     * Private constructor to avoid object creation
     */
    private PrimeNumbersDecisioner() {}
}
