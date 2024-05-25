package interthread.comm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class InterThreadCommunicationExample {
    public static void main(String args[]) {

        final Queue sharedQ = new LinkedList();

        Thread producer = new Producer(sharedQ);
        Thread consumer = new Consumer(sharedQ);

        producer.start();
        consumer.start();

        int[]x = new int[10];
        System.out.println("primitive array name : "+x.getClass().getName());

        Integer[] y = new Integer[10];
        System.out.println("primitive array name : "+y.getClass().getName());

        int[] p = new int[-1];


        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // Print the ArrayList before removal
        System.out.println("ArrayList before removal: " + numbers);

        // Create an iterator for the ArrayList
        Iterator<Integer> iterator = numbers.iterator();

        // Remove the element 30 using iterator
        while (iterator.hasNext()) {
            int number = iterator.next();
            if (number == 30) {
                iterator.remove(); // Remove the current element from the ArrayList
            }
        }
    }

}
