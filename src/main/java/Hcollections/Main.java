package Hcollections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        
        // Arraylist methods

        ArrayList<String> food = new ArrayList<>();

        food.add("apple");
        food.add("orange");
        food.add("pear");
        food.add("kiwi");

        System.out.println(food);

        // accessing items
        food.get(0);
        food.set(0, "grapes");
        food.remove(1);
        //food.clear();
        food.size();
        
        for (String a : food){
            System.out.println(a);
        }

        Collections.sort(food);
        for (String b: food){
            System.out.println(b);
        }


        // Deque implemetns the deque interface. Double-ended queue.
        // LIFO + FIFO

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(1); // added to the head
        deque.addLast(2); // adds to the tail

        deque.offerFirst(3); // returns boolean
        deque.offerLast(5); // returns boolean

        deque.removeFirst(); // errors out if nothing there
        deque.removeLast();
        deque.pollFirst(); // doesnt error is empty
        
        deque.peekFirst(); // return null if empty - doesnt remove anything

        HashMap<String, Integer> map = new HashMap<>();
        // unique keys values can be anything(duplicates ok)

        map.put("a", 1); // put
        map.put("b", 2);
        map.put("a", 3); // replace

        // accessing + updating

        //put
        map.putIfAbsent("a", 5);
        map.putIfAbsent("c", 5);

        map.get("a"); // search by keys

        for (Integer value : map.values()){
            System.out.println(value);
        }

        for(String keys : map.keySet()){
            System.out.println(keys);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();     // get the key
            Integer value = entry.getValue(); // get the value

            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}






/*
 
Collections
-----------

- Arrays had some disadvantages
    - Not resizable
    - NO methods

Collections - a framework that provides a dynamic way to manage objects. 
            - implements List, map, set and deque interaces. 
            - generics - newer implementation of collections - gives type safety <t>.

characteristics:
            - Resizable, grow+shrink
            - specific data types
            - Flexible - primitives allowed as wrapped as objects.

types of collectiom:
            - list: Ordered (indexed), duplicates allowed (arraylist, linkedlist) 
                    slow search times + heavy ops cost. O(n)
            - sets: unordered (unindexed), unique elements (hashSet, treeSet)
            - maps: Unordered (unindexed), key-value pairs (hashMap, linkedhashMap, TreeMap)

// no generics

        // ArrayList list = new ArrayList();
        // list.add(123);
        // list.add("onetwothree");

        // ArrayList<String> list = new ArrayList<>();
        // //list.add(123);
        // list.add("onetwothree");
























 */