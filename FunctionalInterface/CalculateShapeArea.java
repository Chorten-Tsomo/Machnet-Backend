package FunctionalInterface;

public class CalculateShapeArea {
    public static void main (String []args){
        Shape Circle = (x,y)  -> Math.PI*(x*x);
        Shape Rectangle = (x,y) -> (x*y);
        Shape Hexagon = (x,y) -> (6*(x*x))/(4*Math.tan(Math.PI/6));

        System.out.println("Area of Circle is " +Circle.calculateArea(4,0));
        System.out.println("Area of Rectangle is " +Rectangle.calculateArea(7,8));
        System.out.println("Area of Hexagon is " +Hexagon.calculateArea(6,0));


    }

}
