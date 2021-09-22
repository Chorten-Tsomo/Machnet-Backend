package Polymorphism;

import java.util.Random;

public class ShapeGenerator {
    private Random rand = new Random();

    public ShapeGenerator() {
    }

    public Shape next() {
        switch(this.rand.nextInt(3)) {
            case 0:
            default:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }
}
