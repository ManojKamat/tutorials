import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class Test2 {

    private static final String SWIFT_X = "^[A-Za-z0-9]*$";

    public static final boolean isNotNull(String value) {
        return null != value && !"".equals(value);
    }

    public static final boolean isNotNullCheckSpace(String value) {
        return isNotNull(value) && value.trim().length() != 0;
    }

    private static boolean validate(String input, BiPredicate<String, Integer> greaterThen, int reqLength,
            BiPredicate<String, String> validCharset, String regex) {
        return greaterThen.test(input, reqLength) && validCharset.test(input, regex);
    }

    public static void main(String[] args) {
        if (!isNotNullCheckSpace(" ")) {
            // System.out.println("Should not be empty");
        }

        final Function<String, Integer> getLength = t -> Optional.of(t).orElse("").length();
        final BiPredicate<String, Integer> greaterThen = (t, u) -> getLength.apply(t) <= u;
        final BiPredicate<String, String> validCharset = (t, u) -> t.matches(u);

        if (!validate("sada", greaterThen, 3, validCharset, SWIFT_X)) {
            System.out.println("Invalid");
        } else {
            System.out.println("Valid");
        }
    }
}
