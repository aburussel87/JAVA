package Synchronization;

public class SynchronizationDemo {
    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(()->{
            for(int i = 0; i < 10000; i++){
                counter();
            }
        });
        Thread two = new Thread(()->{
            for(int i = 0; i < 10000; i++){
                counter();
            }
        });
        one.start();
        two.start();
        one.join();
        two.join();
        System.out.println("Final value: " + counter);
    }
    
    private synchronized static void counter(){
            counter++;
    }
}
