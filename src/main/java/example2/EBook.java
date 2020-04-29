package example2;

import example1.Book;

import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class EBook extends Book {
    public final List<String> supportedDevices;

    public EBook(String title, List<String> authors, String isbn, Date publishedAt, List<String> supportedDevices) {
        super(title, authors, isbn, publishedAt);
        this.supportedDevices = Collections.unmodifiableList(supportedDevices);
    }

    @Override
    public String getKind() {
        return "Ebook";
    }

    public static void main(String [] args) {
        EBook ebook = new EBook("Distributed System", List.of("Andrew S. Tanenbaum"),
                "15433057381", new GregorianCalendar(2017, 1, 1).getTime(),
                List.of("Kindle"));
        System.out.println("As Ebook: " + ebook.getKind());

        Book book = ebook;
        System.out.println("As Book: " + book.getKind());
    }
}

