class Q {
    int x;
    boolean valueset = false;

    synchronized int consume() {
        while (!valueset) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumer Consumes: " + x);
        valueset = false;
        notifyAll();
        return x;
    }

    synchronized void produce(int x) {
        while (valueset) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producer Produces: " + x);
        this.x = x;
        valueset = true;
        notifyAll();
    }
}

class producer implements Runnable {
    Thread t;
    Q q;

    producer(Q q) {
        this.q = q;
        t = new Thread(this, "producer");
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.produce(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class consumer implements Runnable {
    Q q;
    Thread t;

    consumer(Q q) {
        this.q = q;
        t = new Thread(this, "consumer");
    }

    @Override
    public void run() {
        while (true) {
            q.consume();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class CorrectPc {
    public static void main(String[] args) {
        Q q = new Q();
        producer p = new producer(q);
        consumer c = new consumer(q);
        p.t.start();
        c.t.start();
    }
}
