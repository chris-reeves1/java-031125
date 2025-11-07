package Hcollections;

import java.util.*;

public class LinkedListBestCase {
    public static void main(String[] args) {
        final int n = 200_000, ops = 10_000;

        // Prepare lists
        List<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) arr.add(i);

        LinkedList<Integer> link = new LinkedList<>(arr);

        // Warm up
        for (int i = 0; i < 5_000; i++) { arr.contains(-1); link.contains(-1); }

        // ArrayList: repeatedly insert at middle (pays shift each time)
        long t0 = System.nanoTime();
        int mid = arr.size() / 2;
        for (int i = 0; i < ops; i++) arr.add(mid, -i); // each insert shifts ~n/2
        long t1 = System.nanoTime();

        // LinkedList: move iterator ONCE to middle, then add next to it (O(1) per add)
        long t2 = System.nanoTime();
        ListIterator<Integer> it = link.listIterator(link.size() / 2);
        for (int i = 0; i < ops; i++) it.add(-i); // no traversal between adds
        long t3 = System.nanoTime();

        System.out.printf("ArrayList middle inserts: %.2f ms%n", (t1 - t0)/1e6);
        System.out.printf("LinkedList (iterator parked) inserts: %.2f ms%n", (t3 - t2)/1e6);
    }
}

