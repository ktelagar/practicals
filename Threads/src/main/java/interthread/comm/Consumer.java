package interthread.comm;

import java.util.Queue;
import java.util.logging.Logger;

public class Consumer extends Thread {
    private static final Logger logger = Logger.getLogger(String.valueOf(Consumer.class));
    private final Queue sharedQ;

    public Consumer(Queue sharedQ) {
        super("Consumer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        System.out.println("INSIDE CONSUMER");
        while(true) {
            System.out.println("Consumer is invoked..but hasnt  yet got the lock");
            synchronized (sharedQ) {
                System.out.println("Consumer acquaried the lock");
                while (sharedQ.size() == 0) {
                    try {
                        System.out.println("CONS : Queue is empty, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                int number = (int) sharedQ.poll();
                System.out.println("consuming : " + number);
                sharedQ.notify();
                System.out.println("Consumer sent Notify");

                if(number == 13){break; }
            }
        }
    }
}