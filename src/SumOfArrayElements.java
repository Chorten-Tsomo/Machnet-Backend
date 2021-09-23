import java.util.*;

public class SumOfArrayElements {
    public static void main(String []args) {

        int size = 50;

    List <Integer> arrays = new ArrayList<Integer>(size);

    for (int i = 0; i<= size; i++){
        arrays.add(i);

    }


    int sum = arrays.stream().reduce(0, (element1, element2) -> element1 + element2);
    System.out.println("The sum of all elements is " +sum);

    }
}
