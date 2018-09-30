package by.bsuir.kaziukovich.task5.runner;

import by.bsuir.kaziukovich.common.ConsoleScanner;
import by.bsuir.kaziukovich.task5.subsequence.SubSequenceExtractor;

/**
 * Class to show implementation of task 5
 */
public class Runner {
    /**
     * Gets sequence from console
     * @return Inputted sequence
     */
    private static int[] getSequenceFromConsole() {
        int[] sequence;

        System.out.print("Enter sequence length: ");
        sequence = new int[ConsoleScanner.getNonNegativeInt()];
        for (int i = 0; i < sequence.length; i++) {
            System.out.print("Enter member " + (i + 1) + " out of " + sequence.length + ": ");
            sequence[i] = ConsoleScanner.getInt();
        }
        return sequence;
    }

    /**
     * Entry point for program
     * @param args CLI commands, not in use
     */
    public static void main(String[] args) {
        int[] sequence;

        System.out.println("Enter sequence to analyze");
        sequence = getSequenceFromConsole();
        System.out.println("Minimal amount to extract: " + SubSequenceExtractor.getLeastAmountToExtract(sequence));
    }

    /**
     * Private constructor to prevent object creation
     */
    private Runner() {}
}
