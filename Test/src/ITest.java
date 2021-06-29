public interface ITest {
    void print(String msg);

    public static void main(String[] args) {
        ITest obj = System.out::println;
        obj.print("Hello from interface");
    }
}
