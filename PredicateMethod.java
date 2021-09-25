import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateMethod {
    public static void main (String [] args){
        List<String> names = Arrays.asList("Sean", "Lew","ash", "Chorten", "Tsomo", "Arnol");

        Predicate<String> lengthIs5 = x -> x.length() <=5;
        Predicate<String> startWithA = x -> x.startsWith("A");
        Predicate<String> startWitha = x -> x.startsWith("a");

        List<String> collect = names.stream()
                .filter((startWithA).or(startWitha).and(lengthIs5))
                .collect(Collectors.toList());

        System.out.println(collect);


    }
}
