interface Alpha
{   void f();
    default void reset() {
        //default must be defined
        System.out.println("Alpha's reset");
    }
    // public void f();
    // public static void f1(){
    //     //static must be defined as not inherited by implementing class
    // }
    // private void m(){
    //     //private must be defined
    // }
}

 interface Beta extends Alpha //extends Alpha
{
    default void f(){

    }
    default void reset() {
        System.out.println("Beta's reset");
    }
}
public class InterfaceMultipleInheritanceTest implements Alpha, Beta {

    public void reset() {
        System.out.println("My reset");
    }
}
