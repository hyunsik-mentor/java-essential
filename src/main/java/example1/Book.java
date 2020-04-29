package example1;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Book {
    public final String title;
    public final List<String> authors;
    public final String isbn;
    public final Date publishedAt;
    private long numberOfCopies;

    public Book(String title, List<String> authors, String isbn, Date publishedAt) {
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.publishedAt = publishedAt;
    }

    public void increaseNumberOfCopies(Long n) {
        this.numberOfCopies += n;
    }

    public long getNumberOfCopies() {
        return numberOfCopies;
    }

    public String getKind() {
        return "Paper";
    }

    public static void main(String [] args) {
        Book harryPotter = new Book("Harry Potter", List.of("J. K. Rowling"), "9788983925558",
                new GregorianCalendar(2001, 10, 14).getTime());

        Book lordOfRing = new Book("Lord of Ring", List.of("John R. R. Tolkien"), "9780544003415",
                new GregorianCalendar(1954, 9, 20).getTime());
    }
}
