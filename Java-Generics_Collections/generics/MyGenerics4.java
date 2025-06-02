package generics;

class GenCons {
    private double val;
    public <T extends Number> GenCons(T arg) {
        val = arg.doubleValue();
    }

    void showVal() {
        System.out.println("val: " + val);
    }

    public static <V> boolean isIn(V x, V[] a) {
        for (V t : a) {
            if (t == x) return true;
        }
        return false;
    }

    public <V> boolean isIn2(V x, V[] a) {
        for (V t : a) {
            if (t == x) return true;
        }
        return false;
    }
}

public class MyGenerics4 {
    public static <T extends Comparable<T>, V extends T> boolean isIn(T val, V[] arr){
        for(T x: arr){
            if(x == val) return true;
        }
        return false;
    }   
    public static void main(String args[]) {
        Double[] nums = {1.2,4.9,2.9};
        if(isIn(2.3,nums)){
            System.out.println(true);
        }
        GenCons test = new <Integer>GenCons(100);
        GenCons test2 = new GenCons(123.5d);
        test.showVal();
        test2.showVal();
        Integer[] iArray = {1, 2, 3, 4, 5};
        String[] sarr = {"A","B","C"};
        System.out.println(GenCons.<Integer>isIn(1, iArray));
        System.out.println(GenCons.<String>isIn("A", sarr));
        System.out.println(test.<String>isIn2("B", sarr));
        System.out.println(test.<Integer>isIn2(1,iArray));
        System.out.println(test.isIn2(1, iArray));
        Character c = 'c';
        System.out.println(Integer.valueOf(c));        myclass<Integer> x = new myclass<>(1);
        System.out.println(x);
    }
}

class myclass<T extends Number>{
    T object; 
    public myclass(T ob){
        object = ob;
    }
    @Override
    public String toString(){
        return String.valueOf(object);
    }
}