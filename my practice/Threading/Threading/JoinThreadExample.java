package Threading;

public class JoinThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread One  = new Thread(()->{
            for (int i = 0; i < 20; i++) {
                System.out.println("ThreadOne: "+i);
            }
        });

        Thread Two = new Thread(()->{
            for (int i = 0; i < 20; i++) {
                System.out.println("ThreadTwo: "+i);
            }
        });

        One.start();
        Two.start();
        One.join();
        Two.join();
        System.out.println("Terminating the main method!");
    }
}
