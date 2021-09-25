import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateDescendingNumbers {

    public static void main(String [] args) {


        List<Integer> list = new ArrayList<Integer>(100);

        for (int i = 0; i <=100; i++){
            list.add(i);

        }
        List<Integer> sortedList = list.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sortedList);

    }





}
