package synchronization;

public class class_level {
    void print(String name){
        synchronized(class_level.class){//synchronized(this) will cause instance level lock
            for(int i = 0; i<10; i++){
                System.out.println(name+" : "+i);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        class_level ob1 = new class_level();
        class_level ob2 = new class_level();
        Thread t1 = new Thread(()->ob1.print("T1"));
        Thread t2 = new Thread(()->ob2.print("T2"));
        t1.start();//though works on different object, they dont run concurrently
        t2.start();//because class level lock is obtained;
    }
}
