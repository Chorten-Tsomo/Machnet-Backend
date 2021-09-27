import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FirstExceptionTest {
    public static void main(String []args) throws FileNotFoundException, IOException {

        File filedetails = new File("C:/Javaexceptiontest.txt");

        if(!filedetails.exists()){
            throw new FileNotFoundException("File not exist" +filedetails.toString());
        }
        else{
            System.out.println("Welcome into the file" +filedetails.toString());
        }

    }
}
