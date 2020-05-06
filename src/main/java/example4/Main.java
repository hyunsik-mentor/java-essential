package example4;

import example3.Book;
import example3.EBook;
import example3.Paperback;

import java.util.GregorianCalendar;
import java.util.List;

public class Main {
    public static void main(String [] args) {
        List<Publisher> publishers = List.of(
                new AbcPublisher(),
                new GoodPublisher()
        );

        List<Book> books = List.of(
                new EBook("Distributed System", List.of("Andrew S. Tanenbaum"),
                        "15433057381", new GregorianCalendar(2017, 1, 1).getTime(),
                        List.of("Kindle")),
                new Paperback("Harry Potter", List.of("J. K. Rowling"), "9788983925558",
                        new GregorianCalendar(2001, 10, 14).getTime()),
                new Paperback("Lord of Ring", List.of("John R. R. Tolkien"), "9780544003415",
                        new GregorianCalendar(1954, 9, 20).getTime())
        );

        for (Publisher publisher : publishers) {
            for (Book book : books) {
                publisher.publish(book);
            }
        }
    }
}
