package static_block;

public class Duck extends Bird {
    static {
        System.out.println("Duck's static block is called");
    }

    public Duck() {
        System.out.println("Duck::new() is called");
    }

    public static void main(String [] args) {
        Duck duck = new Duck();
    }
}

