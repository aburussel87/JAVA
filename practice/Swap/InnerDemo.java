class InnerDemo {
    int a = 10;

    void print() {
        System.out.println("Inner");
        System.out.println(a);
    }

    class inner1 {
        int a = 20;

        void print() {
            System.out.println("Inner 1");
            System.out.println(a);
            System.out.println(InnerDemo.this.a);
        }

        class inner2 {
            int a = 30;

            void print() {
                System.out.println("Inner 2");
                System.out.println(a);
                System.out.println(inner1.this.a);
                System.out.println(InnerDemo.this.a);
            }
        }
    }

    public static void main(String[] args) {
            InnerDemo x = new InnerDemo();
            x.print();
            InnerDemo.inner1 y = x.new inner1();
            y.print();
            InnerDemo.inner1.inner2 z = y.new inner2();
            z.print();
    }
}
