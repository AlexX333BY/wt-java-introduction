package by.bsuir.kaziukovich.task12.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for Book class
 */
class BookJUnitTest {
    private static Book createTestBook(String isbn) {
        return new Book("title", "author", 0, isbn);
    }

    /**
     * Tests for compareTo() method
     */
    @Test
    void compareTo() {
        Assertions.assertEquals(0,
                createTestBook("978-1-11-111111-1").compareTo(createTestBook("978-1-11-111111-1")));
        Assertions.assertTrue(createTestBook("978-1-11-111111-1")
                .compareTo(createTestBook("979-1-11-111111-1")) < 0);
        Assertions.assertTrue(createTestBook("979-1-11-111111-1")
                .compareTo(createTestBook("978-1-11-111111-1")) > 0);
        Assertions.assertTrue(createTestBook("978-1-11-111111-X")
                .compareTo(createTestBook("978-1-11-111111-1")) > 0);
        Assertions.assertTrue(createTestBook("978-1-11-110111-1")
                .compareTo(createTestBook("978-1-11-111111-1")) < 0);
        Assertions.assertTrue(createTestBook("978-21-11-10131-1")
                .compareTo(createTestBook("978-20-41-11941-X")) > 0);
    }
}