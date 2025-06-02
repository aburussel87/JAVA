package generics;
import java.util.ArrayList;
import java.util.List;

public class MyGenerics1<T> {
    private T a;

    public void setObj(T a) {
        this.a = a;
    }

    public T getObj() {
        return this.a;
    }

    public static void main(String[] args) {
        MyGenerics1<Integer> myGenerics = new MyGenerics1<Integer>();
        myGenerics.setObj(10);
        System.out.println(myGenerics.getObj());
        MyGenerics1<String> myGenerics1 = new MyGenerics1<>();
        myGenerics1.setObj("Hello");
        String str = myGenerics1.getObj();
        System.out.println(str);
        MyGenerics1<Object> my = new MyGenerics1<>();
        my.setObj(1);
        System.out.println(my.getObj());
        my.setObj("String");
        System.out.println(my.getObj());
        List<MyGenerics1<Object>> lists = new ArrayList<>();
        System.out.println(lists.size());
        MyGenerics1<Object>[] x = new MyGenerics1[2];
        x[0] = new MyGenerics1<>();
        x[1] = new MyGenerics1<>();
        x[0].setObj(1);
        x[1].setObj("string");
        for(int i = 0; i<2; i++){
            System.out.println(x[i].getObj());
        }
        /*MyGenerics1 noGenerics = new MyGenerics1(); // still possible
        noGenerics.setObj(20);
        noGenerics.setObj("World");
        System.out.println(noGenerics.getObj());*/
    }
}


