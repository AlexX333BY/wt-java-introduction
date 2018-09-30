package by.bsuir.kaziukovich.task13.runner;

import by.bsuir.kaziukovich.common.ConsoleScanner;
import by.bsuir.kaziukovich.task12.book.Book;
import by.bsuir.kaziukovich.task13.programmerbook.ProgrammerBook;

public class Task13Runner {
    /**
     * Creates book by user input
     * @return Book generated by user input
     */
    private static ProgrammerBook inputProgrammerBook() {
        String author;
        String title;
        int price;
        String language;
        int level;

        System.out.print("Enter book title: ");
        title = ConsoleScanner.getString();
        System.out.print("Enter book author: ");
        author = ConsoleScanner.getString();
        System.out.print("Enter book price: ");
        price = ConsoleScanner.getNonNegativeInt();
        System.out.print("Enter book language: ");
        language = ConsoleScanner.getNonEmptyString();
        System.out.print("Enter book level: ");
        level = ConsoleScanner.getInt();

        return new ProgrammerBook(title, author, price, language, level);
    }

    /**
     * Entry point for program
     * @param args CLI arguments, not in use
     */
    public static void main(String[] args) {
        ProgrammerBook book1;
        ProgrammerBook book2;

        System.out.println("Fill book 1 info");
        book1 = inputProgrammerBook();
        System.out.println("Fill book 2 info");
        book2 = inputProgrammerBook();

        System.out.print("Enter book edition: ");
        Book.setEdition(ConsoleScanner.getNonNegativeInt());

        System.out.println("Are books equal? " + book1.equals(book2));

        System.out.println("Books hash codes:");
        System.out.println("\tBook 1: " + book1.hashCode());
        System.out.println("\tBook 2: " + book2.hashCode());

        System.out.println("Books string representation:");
        System.out.println("\tBook 1: " + book1.toString());
        System.out.println("\tBook 2: " + book2.toString());
    }
}