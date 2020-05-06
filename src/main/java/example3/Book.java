package example3;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class Book {
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

    public final long getNumberOfCopies() {
        return numberOfCopies;
    }

    public abstract String getKind();
}
