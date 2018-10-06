package by.bsuir.kaziukovich.task12.book;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Class for Book representation
 */
public class Book implements Comparable<Book> {
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
     * Book ISBN
     */
    private String isbn;

    /**
     * Parts of ISBN
     */
    private final static int ISBN_PARTS = 5;

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
        return Objects.equals(book.title, title) && Objects.equals(book.author, author) && (price == book.price)
                && Objects.equals(book.isbn, isbn);
    }

    /**
     * Generates hash code of this book
     * @return Hash code of this book
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, author, price, edition, isbn);
    }

    /**
     * Generates string representation of this book
     * @return String representation of this book
     */
    @Override
    public String toString() {
        return getClass().getName() + "@title: " + title + ", author: " + author + ", price: " + price + ", edition: "
                + edition + ", ISBN: " + isbn;
    }

    /**
     * Creates and returns a copy of this object
     * @return Copy of this object
     */
    @Override
    protected Object clone() {
        return new Book(title, author, price, isbn);
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
     * Gets book title
     * @return Book title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets book author
     * @return Book author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets book price
     * @return Book price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets book edition
     * @return Book edition
     */
    public static int getEdition() {
        return edition;
    }

    /**
     * Gets book ISBN
     * @return Book ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Checks if ISBN is correct
     * @param isbn ISBN to check
     * @return True if ISBN is correct, otherwise false
     */
    private static boolean isIsbnCorrect(String isbn) {
        String[] splittedIsbn = isbn.split(Pattern.quote("-"));
        byte indent = 0;
        int isbnLength = 0;

        if ((splittedIsbn.length != 5) && (splittedIsbn.length != 4)) {
            return false;
        }
        if (splittedIsbn.length == 5) {
            if (!splittedIsbn[0].matches("^97[89]$")) {
                return false;
            }
            indent = 1;
        }

        for (String s : splittedIsbn) {
            isbnLength += s.length();
        }

        return (isbnLength == 13)
                && splittedIsbn[indent].matches("^\\d{1,5}$")
                && splittedIsbn[1 + indent].matches("^\\d{2,7}$")
                && splittedIsbn[2 + indent].matches("^\\d{1,6}$")
                && splittedIsbn[3 + indent].matches("^[0-9X]$");
    }

    /**
     * Splits ISBN string to int array
     * @param isbn ISBN string
     * @return Splitted ISBN
     */
    private static int[] splitIsbnToInt(String isbn) {
        final int DEFAULT_ISBN_FIRST_PART = 978;
        int[] result = new int[ISBN_PARTS];
        String[] splittedIsbn = isbn.replace("X", "10").split("-");
        int indent = 0;

        /* handling old 4-part ISBN */
        if (splittedIsbn.length == ISBN_PARTS - 1) {
            result[0] = DEFAULT_ISBN_FIRST_PART;
            indent = 1;
        }
        for (int i = indent; i < ISBN_PARTS; i++) {
            result[i] = Integer.parseInt(splittedIsbn[i - indent]);
        }

        return result;
    }

    /**
     * Compares two books by ISBN
     * @param book Book to compare to this book
     * @return A negative integer, zero, or a positive integer as this book is less than, equal to, or greater than the specified book
     */
    @Override
    public int compareTo(Book book) {
        int[] thisIsbn = splitIsbnToInt(isbn), otherIsbn;
        int compareResult = 0;

        if (book == null) {
            throw new IllegalArgumentException("Book shouldn't be null");
        }

        otherIsbn = splitIsbnToInt(book.isbn);
        for (int i = 0; (i < ISBN_PARTS) && (compareResult == 0); i++) {
            compareResult = Integer.compare(thisIsbn[i], otherIsbn[i]);
        }
        return compareResult;
    }

    /**
     * Constructor of book
     * @param title Title of book
     * @param author Author of book
     * @param price Price of book
     */
    public Book(String title, String author, int price, String isbn) {
        if (title == null) {
            throw new IllegalArgumentException("Title shouldn't be null");
        }
        if (author == null) {
            throw new IllegalArgumentException("Author shouldn't be null");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (isbn == null) {
            throw new IllegalArgumentException("ISBN shouldn't be null");
        }
        if (!isIsbnCorrect(isbn)) {
            throw new IllegalArgumentException(("ISBN is not correct"));
        }

        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }
}