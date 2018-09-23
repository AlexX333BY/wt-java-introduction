package by.bsuir.kaziukovich.task4.primenumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class PrimeNumbersDecisionerJUnitTest {

    @Test
    void hasArrayPrimeNumbers() {
        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<Integer> expectedIndexes = new ArrayList<>();

        Assertions.assertThrows(IllegalArgumentException.class, () -> PrimeNumbersDecisioner.hasArrayPrimeNumbers(null, null));
        Assertions.assertDoesNotThrow(() -> PrimeNumbersDecisioner.hasArrayPrimeNumbers(new int[2], null));

        expectedIndexes.clear();
        indexes.clear();
        expectedIndexes.add(2);
        expectedIndexes.add(3);
        expectedIndexes.add(5);
        Assertions.assertTrue(PrimeNumbersDecisioner.hasArrayPrimeNumbers(new int[]{0, 1, 2, 3, 4, 5}, indexes));
        Assertions.assertEquals(expectedIndexes, indexes);

        expectedIndexes.clear();
        indexes.clear();
        expectedIndexes.add(0);
        Assertions.assertTrue(PrimeNumbersDecisioner.hasArrayPrimeNumbers(new int[]{3}, indexes));
        Assertions.assertEquals(expectedIndexes, indexes);

        expectedIndexes.clear();
        indexes.clear();
        Assertions.assertFalse(PrimeNumbersDecisioner.hasArrayPrimeNumbers(new int[]{1, 4}, indexes));
        Assertions.assertEquals(expectedIndexes, indexes);

        Assertions.assertFalse(PrimeNumbersDecisioner.hasArrayPrimeNumbers(new int[]{}, indexes));
        Assertions.assertEquals(expectedIndexes, indexes);
    }
}