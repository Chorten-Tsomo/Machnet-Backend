import java.util.Scanner;
public class QuadraticEquation
{
    public static void main(String []args)
    {
        Scanner input=new Scanner(System.in);
        //Quadratic variable declaration
        double a,b,c;


        //Quadratic variable initialization
        System.out.println("Enter value of a:");
        a=input.nextDouble();
        System.out.println("Enter value of b:");
        b=input.nextDouble();
        System.out.println("Enter value of c:");
        c=input.nextDouble();


        double d=(b*b)-(4*a*c);
        double D=Math.sqrt(d);
        double r=2*a;

        //Check for roots
        if(D>0)
        {
            System.out.println("Roots are real and unequal");

            double root1=(D-b)/r;
            double root2=(-D-b)/r;
            System.out.println("Roots are");
            System.out.println(root1);
            System.out.println(root2);

        }

        else if (D==0)
        {
            System.out.println("The roots of the quadratic equation are real and equal");
            double root=(-b)/r;
            System.out.println("Root is "+root);
        }
        else
        {
            System.out.println("The roots of the quadratic equation are complex nd different");
            System.out.println("Roots are ");
            System.out.println((-b/r)+" +i" + D);
            System.out.println((-b/r)+" -i" + D);

        }




    }
}
