package generics;
import java.util.ArrayList;
import java.util.Random;

interface istack<T extends Number>{
    void push(T x);
    T pop();
    boolean isEmpty();
}
class MyStack<T extends Number> implements istack<T>{
    private int size = 0;
    private ArrayList<T> st;
    public MyStack(){
        st = new ArrayList<>();
    }
    public void push(T x){
        st.add(x);
        size++;
    }
    public T pop(){
        T x = st.get(--size);
        st.remove(size);
        return x;
    }
    public boolean isEmpty(){
        return size == 0; 
    }
    
    int diff(MyStack<?> ob){
        return size-ob.size;
    }
}
class X {
    public static void main(String[] args) {
        MyStack<Integer> ob1 = new MyStack<>();
        for(int i = 0; i<5; i++){
            ob1.push(i);
        }
        MyStack<Double> ob2 = new MyStack<>();
        Random r = new Random();
        for(int i = 0; i<10; i++){
            ob2.push(r.nextDouble());
        }
        System.out.println(ob1.diff(ob2));
    }
}
