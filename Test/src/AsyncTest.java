import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class AsyncTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Supplier<String> supplierTask = () -> "Supplier message";
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplierTask);
        System.out.println(completableFuture.get());
    }
}
