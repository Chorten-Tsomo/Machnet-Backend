import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SecondExceptionTest {
    public static void main(String []args) throws RuntimeException, IOException{
    int a, arm=0, n,temp;
        BufferedReader numberchecked = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number");
        n= Integer.parseInt(numberchecked.readLine());
        temp =n;
        while (n!=0){
            a=n%10;
            arm=arm+(a*a*a);
            n=n/10;
        }
        if(arm==temp)
         System.out.println(temp+ "is a amstrong number");
        else
            throw new RuntimeException(temp+"BadRequestException");
    }

}
