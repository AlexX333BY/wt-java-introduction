package by.bsuir.kaziukovich.task8.runner;

import by.bsuir.kaziukovich.common.ConsoleScanner;
import by.bsuir.kaziukovich.task8.sequencecombination.SequenceCombinator;
import by.bsuir.kaziukovich.task8.sequencecombination.SequenceType;
import java.util.List;
import java.util.Map;

/**
 * Class for presentation of task 8 implementation
 */
public class Task8Runner {
    /**
     * Fills sequence with user input
     * @param sequence Sequence to be filled
     */
    private static void fillSequence(double[] sequence) {
        if (sequence == null) {
            throw new IllegalArgumentException("Sequence shouldn't be null");
        }

        for (int index = 0; index < sequence.length; index++) {
            System.out.print("Enter number " + (index + 1) + " out of " + sequence.length + ": ");
            sequence[index] = ConsoleScanner.getDouble();
        }
    }

    /**
     * Entry point of program. Inputs sequences and outputs new sequence
     * @param args Command line arguments, not in use
     */
    public static void main(String[] args) {
        double[] sequenceA, sequenceB;

        System.out.print("Enter length of sequence A: ");
        sequenceA = new double[ConsoleScanner.getNonNegativeInt()];
        System.out.print("Enter length of sequence B: ");
        sequenceB = new double[ConsoleScanner.getNonNegativeInt()];

        System.out.println("Enter sequence A values");
        fillSequence(sequenceA);
        System.out.println("Enter sequence B values");
        fillSequence(sequenceB);

        try {
            Map<Double, List<SequenceType>> resultSequence
                    = SequenceCombinator.getCombinedSequences(sequenceA, sequenceB);

            System.out.println("Result sequence:");
            for (Map.Entry<Double, List<SequenceType>> mapEntry : resultSequence.entrySet()) {
                for (SequenceType sequenceType : mapEntry.getValue()) {
                    System.out.println(mapEntry.getKey() + " : " + sequenceType.toString());
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
