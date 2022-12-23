import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, Boolean> f = (String e) -> Boolean.valueOf(e);
        System.out.println(f.apply("TRUE"));

        Function<String, Boolean> f1 = new Function<String, Boolean>() {
            @Override
            public Boolean apply(String s) {
                return Boolean.valueOf(s);
            }
        };
        System.out.println(f.apply("FALSE"));

        StringToBoolean f2 = new StringToBoolean();
        System.out.println(f2.apply("some"));

        Function<String, Boolean> f3 = Boolean::valueOf;
        System.out.println(f3.apply("TRUE"));

        Consumer<String> f4 = e -> System.out.println(e);
        f4.accept("Hello!");
        Consumer<String> f5 = System.out::println;
        f5.accept("world!");

        Function<String, String> f6 = e -> e.toLowerCase();
        System.out.println(f6.apply("hi!!!"));
        Function<String, String> f7 = String::toLowerCase;

        Function<String, Integer> f8 = e -> new Integer(e);
        System.out.println(f8.apply("6"));
        Function<String, Integer> f9 = Integer::new;
        System.out.println(f9.apply("11"));
    }
}

class StringToBoolean implements Function<String, Boolean>{

    @Override
    public Boolean apply(String s) {
        return Boolean.valueOf(s);
    }
}