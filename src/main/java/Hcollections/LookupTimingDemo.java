package Hcollections;
import java.util.*;

public class LookupTimingDemo {
    public static void main(String[] args) {
        int n = 1_000_00; // 100k for quick demo; increase if you like
        List<Integer> arrayList = new ArrayList<>(n);
        Set<Integer> hashSet = new HashSet<>(n * 2);
        Map<Integer, Integer> hashMap = new HashMap<>(n * 2);

        for (int i = 0; i < n; i++) {
            arrayList.add(i);
            hashSet.add(i);
            hashMap.put(i, i);
        }

        int miss = -1;     // a value not present
        int hit = n - 1;   // a value present

        // Warm-up
        for (int i = 0; i < 3_000; i++) {
            arrayList.contains(hit);
            hashSet.contains(hit);
            hashMap.get(hit);
        }

        time("ArrayList.contains (hit)", () -> arrayList.contains(hit));
        time("ArrayList.contains (miss)", () -> arrayList.contains(miss));

        time("HashSet.contains (hit)", () -> hashSet.contains(hit));
        time("HashSet.contains (miss)", () -> hashSet.contains(miss));

        time("HashMap.get (hit)", () -> hashMap.get(hit));
        time("HashMap.get (miss)", () -> hashMap.get(miss));
    }

    static void time(String label, Runnable r) {
        long t0 = System.nanoTime();
        for (int i = 0; i < 200; i++) r.run();
        long t1 = System.nanoTime();
        System.out.printf("%-28s ~ %7.3f µs per call%n",
                label, (t1 - t0) / 200.0 / 1_000.0);
    }
}