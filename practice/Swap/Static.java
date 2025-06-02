class Static {
    static int a = 3,b;
    int c;
    //static variables are initialized to 0
    static void f1(int x){
        System.out.println("x = "+x);
        System.out.println("a = "+a);
        System.out.println("b = "+b);
        //System.out.println("c = "+c); //error
    }
    int f2(){
        return a*b;
    }
    static{
        b  = a*4;
       // c  = b; //error
    }
    public static void main(String []args){
        f1(42);
        System.out.println("b = "+b);
       // System.out.println("Area = "+f2());
    }
}
