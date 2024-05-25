package interthread.comm;

import java.util.Queue;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class Producer extends Thread {
    private static final Logger logger = Logger.getLogger(String.valueOf(Producer.class));
    private final Queue sharedQ;

    public Producer(Queue sharedQ) {
        super("Producer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        System.out.println("producer is invoked..but hasnt  yet got the lock");
        for (int i = 0; i < 14; i++) {
            synchronized (sharedQ) {
                System.out.println("producer acquaired  the lock");

                while (sharedQ.size() >= 1) {
                    try {
                        System.out.println(" PRO : Queue is full, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println("producing : " + i);
                sharedQ.add(i);
                sharedQ.notify();
                System.out.println("Producer sent Notify");
            }
        }
    }
}