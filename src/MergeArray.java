import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collection;

public class MergeArray {
    public static void main (String [] args) {
        List<List<Integer>> Number = Arrays.asList(
                Arrays.asList(1, 3, 5, 7, 9),
                Arrays.asList(2, 4, 6, 8, 10));

        List<Integer> mergedArray = Number.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(mergedArray.stream()
                .filter(number -> Prime(number))
                .collect(Collectors.toList()));

    }


        public static Boolean Prime(int n){
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if ((n % i) == 0) {
                    count += 1;
                }
            }
            if (count == 2) {
                return true;
            } else {
                return false;
            }

        }








}


