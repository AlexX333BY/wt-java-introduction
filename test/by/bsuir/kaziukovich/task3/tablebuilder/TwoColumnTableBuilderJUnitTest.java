package by.bsuir.kaziukovich.task3.tablebuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

/**
 * Tests for TowColumnTableBuilder
 */
class TwoColumnTableBuilderJUnitTest {
    /**
     * Test for build() method
     */
    @Test
    void build() {
        /* This build() will only create header of table, 10 symbols in row, totally 3 rows */
        Assertions.assertEquals(30, TwoColumnTableBuilder.build(new HashMap<>(), "1", "2").length());

        Assertions.assertThrows(IllegalArgumentException.class, () -> TwoColumnTableBuilder.build(null, "1", "2"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> TwoColumnTableBuilder.build(new HashMap<>(), null, "2"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> TwoColumnTableBuilder.build(new HashMap<>(), "1", null));
    }
}