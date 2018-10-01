package by.bsuir.kaziukovich.task12.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for Book class
 */
class BookJUnitTest {
    /**
     * Default title of test book
     */
    private static final String DEFAULT_TITLE = "title";

    /**
     * Default author of test book
     */
    private static final String DEFAULT_AUTHOR = "author";

    /**
     * Default price of test book
     */
    private static final int DEFAULT_PRICE = 0;

    /**
     * Default ISBN of test book
     */
    private static final String DEFAULT_ISBN = "978-0-00-000000-0";

    /**
     * Creates test book by ISBN
     * @param isbn ISBN to create book by
     * @return Generated book
     */
    private static Book createTestBook(String isbn) {
        return new Book(DEFAULT_TITLE, DEFAULT_AUTHOR, DEFAULT_PRICE, isbn);
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