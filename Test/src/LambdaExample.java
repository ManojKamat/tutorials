public class LambdaExample {
    private static final String HELLO = "Hello World";

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> System.out.println(HELLO);
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();
    }
}
