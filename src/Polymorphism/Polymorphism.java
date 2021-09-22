package Polymorphism;

public class Polymorphism {
    private static ShapeGenerator generator = new ShapeGenerator();

    public Polymorphism() {
    }

    public static void main(String[] args) {
        Shape[] s = new Shape[9];

        int i;
        for(i = 0; i < s.length; ++i) {
            s[i] = generator.next();
        }

        for(i = 0; i < s.length; ++i) {
            s[i].draw();
        }

    }
}
