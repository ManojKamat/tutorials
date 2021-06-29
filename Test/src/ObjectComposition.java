import java.util.Objects;

interface Filter {
    boolean test(String message);
}

interface Logger {
    void log(String message);

    default void filter(Filter filter, String message) {
        Objects.nonNull(filter);
        if (filter.test(message)) {
            log(message);
        }
    }
}

public class ObjectComposition {
    public static void main(String[] args) {
        if (1 == 1) {
            System.out.println("1");
        } else if (2 == 2) {
            System.out.println("2");
        }
    }
}