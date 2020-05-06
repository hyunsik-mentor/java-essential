package example4;

import example3.Book;
import example4.GoodPublisherApi.BookData;

public class GoodPublisher implements Publisher {
    GoodPublisherApi api = new GoodPublisherApi();

    public BookData transform(Book book) {
        BookData bookData = new BookData(book.title, book.authors);
        return bookData;
    }

    @Override
    public String getName() {
        return "Good";
    }

    @Override
    public void publish(Book book) {
        BookData bookData = transform(book);
        api.submitPublication(bookData);
        System.out.println(book.title + " (" + book.getKind() + ") has been published to " + getName());
    }
}
