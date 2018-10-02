package by.bsuir.kaziukovich.task15.bookcomparators;

import by.bsuir.kaziukovich.task12.book.Book;
import java.util.Comparator;

/**
 * Comparator that compares two books by author
 */
public class BookAuthorComparator implements Comparator<Book> {
    /**
     * Compares two books
     * @param book1 First book
     * @param book2 Second book
     * @return Negative integer, zero, or a positive integer as the first book author is less than, equal to, or greater
     *         than the second
     */
    @Override
    public int compare(Book book1, Book book2) {
        if ((book1 == null) || (book2 == null)) {
            throw new IllegalArgumentException("Both books shouldn't be null");
        }

        return book1.getAuthor().compareTo(book2.getAuthor());
    }

    /**
     * Generates string representation of comparator
     * @return String representation of comparator
     */
    @Override
    public String toString() {
        return getClass().getName();
    }

    /**
     * Checks if comparator equals to specified object
     * @param obj Object to check
     * @return True if comparator equals to specified object, otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        return (obj != null) && (getClass() == obj.getClass());
    }

    /**
     * Constructor of comparator
     */
    public BookAuthorComparator() {}
}
