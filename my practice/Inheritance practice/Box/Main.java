class Box {
    double h, b, l;

    Box(Box ob) {
        this.h = ob.h;
        this.b = ob.b;
        this.l = ob.l;
    }

    Box(double l, double b, double h) {
        this.l = l;
        this.b = b;
        this.h = h;
    }

    Box(double x) {
        this.l = this.h = this.b = x;
    }

    public double volume() {
        return l * h * b;
    }

    static void st() {

    }

    void show() {
        System.out.println("from the superclass");
    }

    static int a = 5;

    final void f() {
        System.out.printf("Length: %.2f Breadth: %.2f  Height: %.2f\n", l, b, h);
    }
}

class weightbox extends Box {
    public double w;

    public weightbox(double l, double w, double h, double w2) {
        super(l, w, h);
        this.w = w2;
    }

    public weightbox(Box ob) {
        super(ob);
        this.w = -1;
    }

    public weightbox(weightbox ob) {
        super(ob);
        this.w = ob.w;
    }

    public weightbox(double x, double y) {
        super(y);
        w = x;
    }

    @Override
    void show() {
        super.f();
        System.out.println("weight: " + w);
    }

    @Override
    public double volume() {
        double d = w / super.volume();
        return d;
    }

    // static method can not be overridden
    // @Override
    // void st(){

    // }

    // Final method can not be overridden
    // @Override
    // void f(){

    // }

    void showweight() {

    }
}

public class Main {
    public static void main(String[] args) {
        weightbox subbox = new weightbox(1, 2, 3, 4);
        Box superbox = new Box(subbox);
        superbox.show();// calls show() from the superclass-Box
        subbox.show();// calls show() from the subclass
        weightbox.a = 100;// All instances of box and all subclasses of box now have a with new value 100
        System.out.println(Box.a);
        Box b = new weightbox(subbox);// a new weightbox object is assigned to a reference of Box
                                      // So, b can only access the variables, method of class b0x
                                      // but if any method is overridden by subclasse, then the overridden method of
                                      // that subbclass can be accessed
        b.show();// calls the show() function of subclass though it is a reference of Box but it
                 // cannot access w of boxweight
        // b.w = 10 // invalid!!!
        // but w can be accessed by typecasting 'b' to boxweight
        weightbox newb = (weightbox) b;
        // now newb can access everything from boxweight
        newb.show();
        newb.w = 39;// valid now

    }
}