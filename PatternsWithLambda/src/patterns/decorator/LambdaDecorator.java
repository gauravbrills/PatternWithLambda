package patterns.decorator;

import java.util.function.Function;

/**
 * Created by grawat on 11/14/2015.
 */
public class LambdaDecorator {
    public static void main(String... args) {
        Function<Integer, Integer> inc = e -> e + 1;
        Function<Integer, Integer> dbl = e -> e * 2;
        System.out.println("increment " + doWork(5, inc));
        System.out.println("double " + doWork(5, dbl));
        // increment and double -- method chaining
        System.out.println("increment and double " + doWork(5, inc.andThen(dbl)));
    }

    private static int doWork(int i, Function<Integer, Integer> inc) {
        return inc.apply(i);
    }
}
