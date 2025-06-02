interface I1 {
    void f1();
}

interface I2 extends I1 {
    default void f1() {
        System.out.println("In I2");
    }
    void f2();
}

interface I3 extends I2, I1 {
    void f3();
    default void f1() {
        System.out.println("in I3");
    }
}

class MyClass implements I2 {
    public void f1() {
        System.out.println("IN my class");
    }

    public void f2() {
        System.out.println("Implement f2");
    }

    public void f3() {
        System.out.println("Implement f3");
    }
}

public class InterfaceExtendsTest {
    public static void main(String[] args) {
        MyClass m = new MyClass();
        m.f1();
        m.f2();
        m.f3();
        I2 ob = new MyClass();
        ob.f1();
        ob.f2();
    }
}
