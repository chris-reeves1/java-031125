package Hcollections;

import java.util.*;

public class MiddleOpsDemo {
    public static void main(String[] args) {
        int n = 200_000;
        int mid = n / 2;

        List<Integer> arr = new ArrayList<>(n);
        List<Integer> link = new LinkedList<>();
        for (int i = 0; i < n; i++) { arr.add(i); link.add(i); }

        // Warm-up
        arr.get(mid); link.get(mid);

        // Insert at middle
        time("ArrayList add(mid)", () -> {
            List<Integer> a = new ArrayList<>(arr); // copy to isolate timing
            a.add(a.size()/2, -1);
        });

        time("LinkedList add(mid)", () -> {
            List<Integer> l = new LinkedList<>(link);
            l.add(l.size()/2, -1);
        });

        // Remove at middle
        time("ArrayList remove(mid)", () -> {
            List<Integer> a = new ArrayList<>(arr);
            a.remove(a.size()/2);
        });

        time("LinkedList remove(mid)", () -> {
            List<Integer> l = new LinkedList<>(link);
            l.remove(l.size()/2);
        });
    }

    static void time(String label, Runnable r) {
        long t0 = System.nanoTime();
        r.run();
        long t1 = System.nanoTime();
        System.out.printf("%-22s %7.3f ms%n", label, (t1 - t0) / 1_000_000.0);
    }
}
