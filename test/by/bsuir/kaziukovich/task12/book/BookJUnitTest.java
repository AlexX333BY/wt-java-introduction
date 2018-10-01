package by.bsuir.kaziukovich.task12.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for Book class
 */
class BookJUnitTest {
    /**
     * Default title value for test books
     */
    private final static String DEFAULT_TITLE = "title";

    /**
     * Default author value for test books
     */
    private final static String DEFAULT_AUTHOR = "author";

    /**
     * Default price value for test books
     */
    private final static int DEFAULT_PRICE = 0;

    /**
     * Default ISBN value for test books
     */
    private final static String DEFAULT_ISBN = "978-0-00-000000-0";

    /**
     * Creates new book with provided ISBN and other default values
     * @param isbn Provided ISBN
     * @return New book
     */
    private static Book createTestBookByIsbn(String isbn) {
        return new Book(DEFAULT_TITLE, DEFAULT_AUTHOR, DEFAULT_PRICE, isbn);
    }

    /**
     * Creates new book with provided title and other default values
     * @param title Provided title
     * @return New book
     */
    private static Book createTestBookByTitle(String title) {
        return new Book(title, DEFAULT_AUTHOR, DEFAULT_PRICE, DEFAULT_ISBN);
    }

    /**
     * Creates new book with provided author and other default values
     * @param author Provided author
     * @return New book
     */
    private static Book createTestBookByAuthor(String author) {
        return new Book(DEFAULT_TITLE, author, DEFAULT_PRICE, DEFAULT_ISBN);
    }

    /**
     * Creates new book with provided price and other default values
     * @param price Provided price
     * @return New book
     */
    private static Book createTestBookByPrice(int price) {
        return new Book(DEFAULT_TITLE, DEFAULT_AUTHOR, price, DEFAULT_ISBN);
    }

    /**
     * Creates new book with provided title, author and other default values
     * @param title Provided title
     * @param author Provided author
     * @return New book
     */
    private static Book createTestBookByTitleAuthor(String title, String author) {
        return new Book(title, author, DEFAULT_PRICE, DEFAULT_ISBN);
    }

    /**
     * Creates new book with provided title, author, price and other default values
     * @param title Provided title
     * @param author Provided author
     * @param price Provided price
     * @return New book
     */
    private static Book createTestBookByTitleAuthorPrice(String title, String author, int price) {
        return new Book(title, author, price, DEFAULT_ISBN);
    }

    /**
     * Tests for compareTo() method
     */
    @Test
    void compareTo() {
        Assertions.assertEquals(0,
                createTestBookByIsbn("978-1-11-111111-1").compareTo(createTestBookByIsbn("978-1-11-111111-1")));
        Assertions.assertTrue(createTestBookByIsbn("978-1-11-111111-1")
                .compareTo(createTestBookByIsbn("979-1-11-111111-1")) < 0);
        Assertions.assertTrue(createTestBookByIsbn("979-1-11-111111-1")
                .compareTo(createTestBookByIsbn("978-1-11-111111-1")) > 0);
        Assertions.assertTrue(createTestBookByIsbn("978-1-11-111111-X")
                .compareTo(createTestBookByIsbn("978-1-11-111111-1")) > 0);
        Assertions.assertTrue(createTestBookByIsbn("978-1-11-110111-1")
                .compareTo(createTestBookByIsbn("978-1-11-111111-1")) < 0);
        Assertions.assertTrue(createTestBookByIsbn("978-21-11-10131-1")
                .compareTo(createTestBookByIsbn("978-20-41-11941-X")) > 0);
    }

    /**
     * Tests for compareByTitleTo() method
     */
    @Test
    void compareByTitleTo() {
        Assertions.assertEquals(0, createTestBookByTitle("same")
                .compareByTitleTo(createTestBookByTitle("same")));
        Assertions.assertNotEquals(0, createTestBookByTitle("some")
                .compareByTitleTo(createTestBookByTitle("another")));
        Assertions.assertNotEquals(0, createTestBookByTitle("some title")
                .compareByTitleTo(createTestBookByTitle("another")));
    }

    /**
     * Tests for compareByAuthorTo() method
     */
    @Test
    void compareByAuthorTo() {
        Assertions.assertEquals(0, createTestBookByAuthor("same")
                .compareByAuthorTo(createTestBookByAuthor("same")));
        Assertions.assertTrue(createTestBookByAuthor("some")
                .compareByAuthorTo(createTestBookByAuthor("another")) > 0);
        Assertions.assertTrue(createTestBookByAuthor("some title")
                .compareByAuthorTo(createTestBookByAuthor("another")) > 0);
        Assertions.assertTrue(createTestBookByAuthor("another")
                .compareByAuthorTo(createTestBookByAuthor("some")) < 0);
    }

    /**
     * Tests for compareByPriceTo() method
     */
    @Test
    void compareByPriceTo() {
        Assertions.assertEquals(0, createTestBookByPrice(0)
                .compareByPriceTo(createTestBookByPrice(0)));
        Assertions.assertTrue(createTestBookByPrice(0)
                .compareByPriceTo(createTestBookByPrice(4)) < 0);
        Assertions.assertTrue(createTestBookByPrice(5)
                .compareByPriceTo(createTestBookByPrice(2)) > 0);
    }

    /**
     * Tests for compareByTitleAuthorTo() method
     */
    @Test
    void compareByTitleAuthorTo() {
    }

    /**
     * Tests for compareByAuthorTitleTo() method
     */
    @Test
    void compareByAuthorTitleTo() {
    }

    /**
     * Tests for compareByAuthorTitlePriceTo() method
     */
    @Test
    void compareByAuthorTitlePriceTo() {
    }
}