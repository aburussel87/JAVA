package Threading;

public class RunnableThread {
    public static void main(String[] args) {
        Thread One = new Thread(new ThreadOne());
        Thread Two = new Thread(new ThreadTwo());
        Thread Three = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread Three: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread Five = new Thread(()->{
            for(int i = 0; i < 10; i++){
                System.out.println("Thread Five: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

//        ThreadOne thread_four = new ThreadOne();
//        Thread Four = new Thread(thread_four);

        One.start();
        Two.start();
        Three.start();
        Five.start();
    }
}

class ThreadOne implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("ThreadOne: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class ThreadTwo implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("ThreadTwo: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}