package by.bsuir.kaziukovich.task15.bookcomparators;

import by.bsuir.kaziukovich.task12.book.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Tests for BookAuthorTitlePriceComparator class
 */
class BookAuthorTitlePriceComparatorJUnitTest {
    /**
     * Test book ISBN
     */
    private static final String DEFAULT_ISBN = "978-0-00-000000-0";

    /**
     * Creates test book
     * @param title Title of book
     * @param author Author of book
     * @param price Price of book
     * @return New test book
     */
    private Book createTestBook(String title, String author, int price) {
        return new Book(title, author, price, DEFAULT_ISBN);
    }

    /**
     * Tests for compare() method
     */
    @Test
    void compare() {
        BookAuthorTitlePriceComparator comparator = new BookAuthorTitlePriceComparator();
        Book book111 = createTestBook("first", "first", 1),
                book112 = createTestBook("first", "first", 2),
                book121 = createTestBook("first", "second", 1),
                book122 = createTestBook("first", "second", 2),
                book211 = createTestBook("second", "first", 1),
                book212 = createTestBook("second", "first", 2),
                book221 = createTestBook("second", "second", 1),
                book222 = createTestBook("second", "second", 2);
        ArrayList<Book> manuallySortedList = new ArrayList<>(),
                comparatorSortedList = new ArrayList<>();

        Assertions.assertEquals(0, comparator.compare(book111, book111));

        /* comparing by authors */
        Assertions.assertTrue(comparator.compare(book111, book121) < 0);
        Assertions.assertTrue(comparator.compare(book122, book112) > 0);

        /* comparing by titles, if authors are same */
        Assertions.assertTrue(comparator.compare(book111, book211) < 0);
        Assertions.assertTrue(comparator.compare(book221, book121) > 0);

        /* comparing by price, if authors are same and titles are same */
        Assertions.assertTrue(comparator.compare(book111, book112) < 0);
        Assertions.assertTrue(comparator.compare(book222, book221) > 0);

        manuallySortedList.add(book111);
        manuallySortedList.add(book112);
        manuallySortedList.add(book211);
        manuallySortedList.add(book212);
        manuallySortedList.add(book121);
        manuallySortedList.add(book122);
        manuallySortedList.add(book221);
        manuallySortedList.add(book222);
        comparatorSortedList.add(book111);
        comparatorSortedList.add(book112);
        comparatorSortedList.add(book121);
        comparatorSortedList.add(book122);
        comparatorSortedList.add(book211);
        comparatorSortedList.add(book212);
        comparatorSortedList.add(book221);
        comparatorSortedList.add(book222);
        comparatorSortedList.sort(comparator);
        Assertions.assertEquals(manuallySortedList, comparatorSortedList);
    }
}