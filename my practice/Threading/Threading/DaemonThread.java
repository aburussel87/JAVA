package Threading;

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
    Thread daemon = new Thread(new daemonhelper());
    Thread thread = new Thread(new UserThread());
    daemon.setDaemon(true);
    daemon.start();
    thread.start();
    thread.join();
        System.out.println("Shutting down thread");
    }
}

class daemonhelper implements Runnable{
    @Override
    public void run() {
        int i = 500;
        while(i>0){
            i--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Daemon helper is running.....");
        }
    }
}

class UserThread implements Runnable{
    @Override
    public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}

