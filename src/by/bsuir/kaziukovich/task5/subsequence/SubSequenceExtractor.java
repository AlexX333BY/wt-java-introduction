package by.bsuir.kaziukovich.task5.subsequence;

/**
 * Class for extracting subsequences
 */
public class SubSequenceExtractor {
    /**
     * Counts and returns minimal amount of numbers that can be extracted to get increasing subsequence
     * @param sequence Sequence to analyze
     * @return Minimal amount of numbers that can be extracted to get increasing subsequence
     */
    public static int getLeastAmountToExtract(int[] sequence) {
        int maxIncreasingLength = 0, curIncreasingLength;
        boolean isIncreasing;

        if (sequence == null) {
            throw new IllegalArgumentException("Sequence shouldn't be null");
        }

        for (int i = 0; i < sequence.length; i++) {
            isIncreasing = true;
            curIncreasingLength = 1;
            for (int j = i + 1; (j < sequence.length) && isIncreasing; j++) {
                if (sequence[j - 1] < sequence[j]) {
                    curIncreasingLength++;
                } else {
                    isIncreasing = false;
                }
            }
            maxIncreasingLength = Math.max(maxIncreasingLength, curIncreasingLength);
        }
        return sequence.length - maxIncreasingLength;
    }

    /**
     * Private constructor to prevent object creation
     */
    private SubSequenceExtractor() {}
}
