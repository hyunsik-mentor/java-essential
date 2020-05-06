package static_block;

public abstract class Bird {
    String name;
    static {
        System.out.println("Bird's static block is called");
    }
    public Bird() {
        System.out.println("Bird::new() is called");
    }
}
