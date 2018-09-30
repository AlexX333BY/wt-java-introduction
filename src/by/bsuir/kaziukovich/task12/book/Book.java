package by.bsuir.kaziukovich.task12.book;

import java.util.Objects;

/**
 * Class for Book representation
 */
public class Book {
    /**
     * Book title
     */
    private String title;

    /**
     * Book author
     */
    private String author;

    /**
     * Book price
     */
    private int price;

    /**
     * Book edition
     */
    private static int edition;

    /**
     * Checks if books equals
     * @param object Object to compare
     * @return True if objects are same, otherwise false
     */
    @Override
    public boolean equals(Object object) {
        Book book;

        if (object == this) {
            return true;
        }
        if ((object == null) || (getClass() != object.getClass())) {
            return false;
        }

        book = (Book) object;
        return title.equals(book.title) && author.equals(book.author) && (price == book.price);
    }

    /**
     * Generates hash code of this book
     * @return Hash code of this book
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, author, price, edition);
    }

    /**
     * Generates string representation of this book
     * @return String representation of this book
     */
    @Override
    public String toString() {
        return getClass().getName() + "@title: " + title + ", author: " + author + ", price: " + price + ", edition: "
                + edition;
    }

    /**
     * Creates and returns a copy of this object
     * @return Copy of this object
     */
    @Override
    protected Object clone() {
        return new Book(title, author, price);
    }

    /**
     * Sets edition of all books
     * @param edition Edition to set
     */
    public static void setEdition(int edition) {
        if (edition <= 0) {
            throw new IllegalArgumentException("Edition should be positive number");
        }

        Book.edition = edition;
    }

    /**
     * Constructor of book
     * @param title Title of book
     * @param author Author of book
     * @param price Price of book
     */
    public Book(String title, String author, int price) {
        if (title == null) {
            throw new IllegalArgumentException("Title shouldn't be null");
        }
        if (author == null) {
            throw new IllegalArgumentException("Author shouldn't be null");
        }
        if (price < 0) {
            throw new IllegalArgumentException("price cannot be negative");
        }

        this.title = title;
        this.author = author;
        this.price = price;
    }
}