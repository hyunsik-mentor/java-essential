package singleton;

public class EmbedDB {
    private static final EmbedDB instance;

    static {
        instance = new EmbedDB();
    }

    private EmbedDB() {
        // something
    }

    public static EmbedDB getInstance() {
        return instance;
    }

    public static void main(String [] args) {
        EmbedDB db = EmbedDB.getInstance();
        // do something with db instance
    }
}
