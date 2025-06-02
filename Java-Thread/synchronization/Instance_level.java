package synchronization;
public class Instance_level
{
    synchronized void print(String x){
        for(int i = 0; i<10; i++){
            System.out.println(x+" : "+i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Instance_level ob1 = new Instance_level();
        Instance_level ob2 = new Instance_level();
        Thread t1 = new Thread(()->ob1.print("T1"));
        Thread t2 = new Thread(()->ob2.print("T2"));
        Thread t3 = new Thread(()->ob1.print("T3"));
        t1.start();//t1 and t2 works on two different objects (possible - t2 and t3)
        t2.start();// so they will be executed concurrently
        t3.start();//on same object, so t1 will execute and t3 will wait for the monitor to be free 
    }
}
