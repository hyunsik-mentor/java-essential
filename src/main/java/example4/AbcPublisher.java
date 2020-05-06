package example4;

import example3.Book;
import example4.AbcPublisherClient.BookDescription;

public class AbcPublisher implements Publisher {
    AbcPublisherClient client;

    public AbcPublisher() {
        client = new AbcPublisherClient();
    }

    @Override
    public String getName() {
        return "Abc";
    }

    @Override
    public void publish(Book book) {
        BookDescription newBook = new BookDescription(book.title, book.authors, book.isbn);
        client.publish(newBook);
        System.out.println(book.title + " (" + book.getKind() + ") has been published to " + getName());
    }
}
