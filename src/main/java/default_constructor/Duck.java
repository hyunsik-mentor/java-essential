package default_constructor;

public class Duck extends Bird {
    public Duck() {
        System.out.println("Duck::new() is called");
    }

    public static void main(String [] args) {
        Duck duck = new Duck();
    }
}

