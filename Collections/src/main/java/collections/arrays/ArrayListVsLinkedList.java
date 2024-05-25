package collections.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListVsLinkedList {

    public static void main(String[] args) {
            int[] arr ;
            arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

     /*   System.out.println("array : "+arr);
        Arrays.stream(arr).forEach(System.out::print);
        arr[7] = 10;


        System.out.println();
        Arrays.stream(arr).forEach(System.out::print);*/

        List al = new ArrayList();
        al.addAll(Arrays.asList(10,20,30));
        System.out.println();
        System.out.println("Array list elements - "+al);

        al.add(2,40);
        System.out.println("Array list elements post insertion - "+al);

        Parent s = new Parent();
        System.out.println("address : "+s);
    }
}
