import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by grawat on 11/14/2015.
 */
public class StrategyWithLambda {
    public static void main(String args[]) {
        String str = "test";
        switch(str){
            case  "test":
                System.out.println();
                break;
        }
        List<Integer> numbers = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        numbers.forEach(e -> System.out.println(e));
        System.out.println("_______________");
        numbers.forEach(System.out::println);
        // Strategy with lambda
        // higher order function
        System.out.println("Sum " + totalValues(numbers, e -> true));
        System.out.println("Sum Even " + totalValues(numbers, e -> e % 2 == 0));
        // with utility class
        System.out.println("Sum Odd " + totalValues(numbers, Utils::isOdd));
    }

    private static int totalValues(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().filter(predicate).reduce(0, Integer::sum);
    }


}
class Utils {
    public static boolean isEven(Integer e) {
        return e % 2 == 0;
    }

    public static boolean isOdd(Integer e) {
        return e % 2 != 0;
    }
}