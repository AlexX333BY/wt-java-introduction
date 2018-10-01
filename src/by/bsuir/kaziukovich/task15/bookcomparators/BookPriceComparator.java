package by.bsuir.kaziukovich.task15.bookcomparators;

import by.bsuir.kaziukovich.task12.book.Book;
import java.util.Comparator;

/**
 * Comparator that compares two books by price
 */
public class BookPriceComparator implements Comparator<Book> {
    /**
     * Compares two books
     * @param book1 First book
     * @param book2 Second book
     * @return Negative integer, zero, or a positive integer as the first book price is less than, equal to, or greater
     *         than the second
     */
    @Override
    public int compare(Book book1, Book book2) {
        if ((book1 == null) || (book2 == null)) {
            throw new IllegalArgumentException("Both books shouldn't be null");
        }

        return Integer.compare(book1.getPrice(), book2.getPrice());
    }

    /**
     * Constructor of comparator
     */
    public BookPriceComparator() {}
}
