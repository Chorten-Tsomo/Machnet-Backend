import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsumerInterface {
    public static boolean isPrime(int i) {
        IntPredicate isDivisible = index -> i % index == 0;
        return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
    }
    public static void main(String [] args){
        int size =50;
        List<Integer> list = new ArrayList<>(size);
        for (int i =0; i<=size; i++) {
            list.add(i);

        }







        Consumer<List<Integer>> evenList = even -> System.out.println(
                "List of even numbers: " + even.stream()
                        .filter(e -> (e%2) == 0 )
                        .collect(Collectors.toList())
        );

        Consumer<List<Integer>> oddList = odd -> System.out.println(
                "List of Odd numbers: " + odd.stream()
                        .filter(o -> (o%2) != 0 )
                        .collect(Collectors.toList())
        );

        Consumer<List<Integer>> primeList = prime -> System.out.println(
                "List of prime numbers: " + prime.stream()
                        .filter(ConsumerInterface::isPrime)
                        .collect(Collectors.toList())
        );

        evenList.accept(list);
        oddList.accept(list);
        primeList.accept(list);















    }
}
