package example3;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Paperback extends Book {
    public Paperback(String title, List<String> authors, String isbn, Date publishedAt) {
        super(title, authors, isbn, publishedAt);
    }

    @Override
    public String getKind() {
        return "Paperback";
    }

    public static void main(String [] args) {
        Paperback ebook = new Paperback("Distributed System", List.of("Andrew S. Tanenbaum"),
                "15433057381", new GregorianCalendar(2017, 1, 1).getTime());
        System.out.println("As Paperback: " + ebook.getKind());

        Book book = ebook;
        System.out.println("As Book: " + book.getKind());
    }
}

