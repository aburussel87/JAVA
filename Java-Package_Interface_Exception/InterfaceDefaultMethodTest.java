interface MyIF {
    // This is a "normal" interface method declaration.
    int getNumber();
    // This is a default method. Notice that it provides
    // a default implementation.
    default String getString()
    {
        return "Default String";
    }
}

class MyIFImp implements MyIF {
    // Only getNumber() defined by MyIF needs to be implemented.
    // getString() can be allowed to default.
    public int getNumber() {
        return 100;
    }
    @Override
    public String getString(){
        return "Overridden string";
    }

}

public class InterfaceDefaultMethodTest {
    public static void main(String[] args) {
        MyIFImp m = new MyIFImp();
        System.out.println(m.getNumber());
        System.out.println(m.getString());
        MyIF ob = new MyIF(){
            @Override
            public int getNumber(){  //must implement the abstract method of the superclass
                return 19;
            }
        };
        MyIF x;
        x = new MyIFImp();
        x.getString();
        System.out.println(ob.getNumber());
        System.out.println(ob.getString());
    }
}
