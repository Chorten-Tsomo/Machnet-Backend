package Interface;

public class ToTestInt {

    public static void main(String[] args) {
        System.out.println("Calling  from ToTestInt class main method");
        Test t = new Arithmetic();
        System.out.println("----------------------");
        System.out.println("Created Object of test interface - reference Arithmetic class");
        System.out.println("Method Calculate square is called");
        System.out.println("Result" + t.calculateSquare(2));
    }
}
