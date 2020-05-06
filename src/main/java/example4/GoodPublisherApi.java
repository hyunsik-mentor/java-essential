package example4;

import java.util.List;

public class GoodPublisherApi {

    public static class BookData {
        public BookData(String title, List<String> authors) {}
    }

    public void submitPublication(BookData book) {
        // something
    }
}
