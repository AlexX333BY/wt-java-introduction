package by.bsuir.kaziukovich.task15.bookcomparators;

import by.bsuir.kaziukovich.task12.book.Book;
import java.util.Comparator;

/**
 * Comparator that compares two books by title
 */
public class BookTitleComparator implements Comparator<Book> {
    /**
     * Compares two books
     * @param book1 First book
     * @param book2 Second book
     * @return Negative integer, zero, or a positive integer as the first book title is less than, equal to, or greater
     *         than the second
     */
    @Override
    public int compare(Book book1, Book book2) {
        if ((book1 == null) || (book2 == null)) {
            throw new IllegalArgumentException("Both books shouldn't be null");
        }

        return book1.getTitle().compareTo(book2.getTitle());
    }

    /**
     * Constructor of comparator
     */
    public BookTitleComparator() {}
}
