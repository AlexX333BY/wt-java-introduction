package by.bsuir.kaziukovich.task13.programmerbook;

import by.bsuir.kaziukovich.task12.book.Book;
import java.util.Objects;

/**
 * Class for Programmer Book representation
 */
public class ProgrammerBook extends Book {
    /**
     * Book language
     */
    private String language;

    /**
     * Book level
     */
    private int level;

    /**
     * Checks if programmer books are same
     * @param object Object to compare
     * @return True if objects are same, false otherwise
     */
    @Override
    public boolean equals(Object object) {
        ProgrammerBook programmerBook;

        if (object == this) {
            return true;
        }
        if ((object == null) || (getClass() != object.getClass())) {
            return false;
        }

        programmerBook = (ProgrammerBook) object;
        return super.equals(object) && Objects.equals(programmerBook.language, language)
                && (programmerBook.level == level);
    }

    /**
     * Generates hash code of programmer book
     * @return Hash code of programmer book
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), language, level);
    }

    /**
     * Generates string representation of programmer book
     * @return String representation of programmer book
     */
    @Override
    public String toString() {
        return super.toString() + ", language: " + language + ", level: " + level;
    }

    /**
     * Constructor of programmer book
     * @param title  Title of book
     * @param author Author of book
     * @param price  Price of book
     * @param language Language of book
     * @param level Level of book
     */
    public ProgrammerBook(String title, String author, int price, String isbn, String language, int level) {
        super(title, author, price, isbn);
        if ((language == null) || language.isEmpty()) {
            throw new IllegalArgumentException("Language shouldn't be empty");
        }

        this.language = language;
        this.level = level;
    }
}
