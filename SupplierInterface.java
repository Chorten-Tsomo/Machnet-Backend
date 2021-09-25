import java.util.function.Supplier;
import java.util.stream.IntStream;

public class SupplierInterface {


    public static void main (String[] args){
        Supplier<Integer> supplier = SupplierInterface :: getTwoDigitPrimeNumber;
        System.out.println(supplier.get());

    }
    public static Integer getTwoDigitPrimeNumber(){
        int prime=0;
        while (true){
            int random = (int) (Math.random()*((100-10) + 1)) + 10;
            if(IntStream.range(2,random).noneMatch(p -> random % p ==0)){
                prime=random;
                break;
            }
        }
        return prime;

    }
}