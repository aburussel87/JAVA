package Threading;

public class ExtendsThread {
    public static void main(String[] args) {
        Thread One = new Thread1();
        Thread Two = new Thread2();
        One.start();
        Two.start();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread1 :"+ i);
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread2 :"+ i);
        }
    }
}
