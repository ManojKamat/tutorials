class Parent {
    public static void hello() {
        System.out.println("Hello from Parent");
    }
}

abstract class Child extends Parent {
    public static void hello() {
        System.out.println("Hello From Child");
    }
}

public class Sample1 extends Child {
    public static void main(String[] args) {
        hello();
    }
}
