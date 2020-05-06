package singleton_v2;

public class LazyEmbedDB {
    private static LazyEmbedDB instance;

    private LazyEmbedDB() {
        // something
    }

    public static LazyEmbedDB getInstance() {
        if (instance == null) {
            instance = new LazyEmbedDB();
        }
        return instance;
    }

    public static void main(String [] args) {
        LazyEmbedDB db = LazyEmbedDB.getInstance();
        // do something with db instance
    }
}
