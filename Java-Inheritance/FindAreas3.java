abstract class Fig {
    double d1, d2;

    // Fig(double a, double b) {
    //     this.d1 = a;
    //     this.d2 = b;
    // }

    // Fig(double a) {
    //     this.d1 = a;
    //     this.d2 = a;
    // }
    Fig(double ... dims){
        if(dims.length == 2){
            d2 = dims[1];
        }
        d1 = dims[0];
    }

    abstract double area();

    void show() {
        System.out.println("a: " + d1 + " b: " + d2);
    }
}

public class FindAreas3 {
    public static void main(String[] args) {
        Fig rec = new Fig(10, 20) {
            double area() {
                return d1 * d2;
            }
        };

        // An anonymous class is a class without a name, declared and instantiated in a
        // single statement.
        // Used to extend classes or implement interfaces for one-time use.
        rec.show();
        System.out.println(rec.area());

        Fig tr = new Fig(10, 20) {
            double area() {
                return d1 * d2 / 2;
            }
        };
        tr.show();
        System.out.println(tr.area());
        Fig square = new Fig(10) {
            @Override
            double area() {
                return d1 * d1;
            }
            @Override
            void show() {
                System.out.println("a :" + d1);
            }
        };
        square.show();
        System.out.println(square.area());

        Fig circle = new Fig(3){
            @Override
            double area(){
                return 3.1416*d1*d1;
            }
            @Override
            void show(){
                System.out.println("Radius : "+d1);
            }
        };
        circle.show();
        System.out.println(circle.area());

    }
}
