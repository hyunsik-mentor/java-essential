package example1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.GregorianCalendar;
import java.util.List;

public class TestBook {
    @Test
    void test() {
        Book harryPotter = new Book("Harry Potter", List.of("J. K. Rowling"), "9788983925558",
                new GregorianCalendar(2001, 10, 14).getTime());
        assertEquals(harryPotter.title, "Harry Potter");
    }

    @Test
    void testBooKind() {
        Book harryPotter = new Book("Harry Potter", List.of("J. K. Rowling"), "9788983925558",
                new GregorianCalendar(2001, 10, 14).getTime());
        assertEquals(harryPotter.getKind(), "Paper");
    }
}
