package by.bsuir.kaziukovich.task5.subsequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for SubSequenceExtractor class
 */
class SubSequenceExtractorTest {
    /**
     * Tests for getLeastAmountToExtract() method
     */
    @Test
    void getLeastAmountToExtract() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> SubSequenceExtractor.getLeastAmountToExtract(null));

        Assertions.assertEquals(0, SubSequenceExtractor.getLeastAmountToExtract(new int[0]));
        Assertions.assertEquals(0, SubSequenceExtractor.getLeastAmountToExtract(new int[1]));
        Assertions.assertEquals(0, SubSequenceExtractor.getLeastAmountToExtract(new int[] {1, 2, 3}));
        Assertions.assertEquals(1, SubSequenceExtractor.getLeastAmountToExtract(new int[] {4, 1, 2, 3}));
        Assertions.assertEquals(1, SubSequenceExtractor.getLeastAmountToExtract(new int[] {1, 2, 3, 0}));
        Assertions.assertEquals(2, SubSequenceExtractor.getLeastAmountToExtract(new int[] {4, 2, 3, 1}));
    }
}