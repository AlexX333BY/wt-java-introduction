package by.bsuir.kaziukovich.task15.bookcomparators;

import by.bsuir.kaziukovich.task12.book.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Tests for BookAuthorTitleComparator class
 */
class BookAuthorTitleComparatorJUnitTest {
    /**
     * Test book price
     */
    private static final int DEFAULT_PRICE = 0;

    /**
     * Test book ISBN
     */
    private static final String DEFAULT_ISBN = "978-0-00-000000-0";

    /**
     * Creates test book
     * @param title Title of book
     * @param author Author of book
     * @return New test book
     */
    private Book createTestBook(String title, String author) {
        return new Book(title, author, DEFAULT_PRICE, DEFAULT_ISBN);
    }

    /**
     * Tests for compare() method
     */
    @Test
    void compare() {
        BookAuthorTitleComparator comparator = new BookAuthorTitleComparator();
        Book book11 = createTestBook("first", "first"),
                book12 = createTestBook("first", "second"),
                book21 = createTestBook("second", "first"),
                book22 = createTestBook("second", "second");
        ArrayList<Book> manuallySortedList = new ArrayList<>(),
                comparatorSortedList = new ArrayList<>();

        Assertions.assertEquals(0, comparator.compare(book11, book11));

        /* comparing by authors */
        Assertions.assertTrue(comparator.compare(book11, book12) < 0);
        Assertions.assertTrue(comparator.compare(book22, book11) > 0);

        /* comparing by titles, if authors are same */
        Assertions.assertTrue(comparator.compare(book11, book21) < 0);
        Assertions.assertTrue(comparator.compare(book22, book12) > 0);

        manuallySortedList.add(book11);
        manuallySortedList.add(book21);
        manuallySortedList.add(book12);
        manuallySortedList.add(book22);
        comparatorSortedList.add(book11);
        comparatorSortedList.add(book12);
        comparatorSortedList.add(book21);
        comparatorSortedList.add(book22);
        comparatorSortedList.sort(comparator);
        Assertions.assertEquals(manuallySortedList, comparatorSortedList);
    }
}