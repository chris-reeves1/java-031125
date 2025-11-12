package Nlambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Person> person = Arrays.asList(
            new Person("chris", 10),
            new Person("john", 12),
            new Person("bev", 20));
        
            person.stream()
            .filter((n) -> n.getName().equals("chris"))
            .map(Person::getAge)
            .forEach(System.out::println);

    }
}

class Person{
    final String name;
    final int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    
}


/*
Lambdas
- Requires a functional interface (single abstract method)
- in-built functional interfaces - although we can build our own. 
- Its just some code - acts mostly like an object that contains behaviour.

under the hood:
- lambdaFactory class - implements our lambdas efficienctly.
- Gets broken into bytecode (static method)
- invokedDynamic()

- Allows behaviour to be expressed in-line.
- Works well with streams.

synatax:
    Runnable lambdaWay = () -> System.out.println("Lambda way!!");
    

    One-param:          () is optional
    no-params:          () needed
    multi-params:       () needed

    body: do we use {}
        One line/expression:            dont need {}
        multiline/multi expression:     do need {}

    Runnable lambdaWay = (a) -> {int a = a**2; return a;}

examples of basic usage: 

        Runnable innerClass = new Runnable() { // anon/inner class
                        @Override public void run(){System.out.println("inner class way");}
                };

                // using a lambda:
                Runnable lambdaWay = () -> System.out.println("Lambda way!!");
                lambdaWay.run();
                innerClass.run();

                runTwice(lambdaWay);
                runTwice(() -> System.out.println("Lambda way!!"));
            }

                private static void runTwice(Runnable r){r.run(); r.run();}

                public static Runnable runRunnable(){return () -> System.out.println("Lambda way!!");}
        }


Method referencing:

 statics:
                    Classname::staticMethod

 instance methods:  instance::method

 constructor:       CLassname::new


// basic syntax for unary operator:

        IntUnaryOperator square = x -> x * x;
        System.out.println(square.applyAsInt(10));
         
        // multi params
        IntBinaryOperator add = (a, b) -> {int x = a + b; return x;};
        System.out.println(add.applyAsInt(10, 20));

        // predicate (returns a boolean)
        Predicate<String> isShort = (s) -> {return s.length() <=5;};
        System.out.println(isShort.test("qwerty")); // flase
        System.out.println(isShort.test("abc")); // true

        // consumer
        Consumer<String> print_ = System.out::println;
        print_.accept("test - will this print??");

        String a = "[LOG] - ";
        Consumer<String> logger = (s) -> System.out.println(a + s);
        logger.accept("Error - unknown arg");


// lists
        List<String> name = new ArrayList<>(); // fully mutable
        name.add("a");
        List<String> name1 = List.of("c", "b", "a"); //  totally immutable list
        // name1.add("a");
        // name1.set(0, "z");
        List<String> name2 = Arrays.asList("a", "b", "c");
        name2.set(0, "z");
        name1.add("a");

//List<String> names = new ArrayList<>(Arrays.asList("chris", "john", "bev")); 
        //names.sort((a, b) -> a.compareTo(b));
        //System.out.println(names);

        //names.sort((a, b) -> b.compareTo(a));
        //System.out.println(names); // reverese the order. 
        //Collections.reverse(names);
        //names.reversed().getFirst();
        //System.out.println(names);

        //foreach
        // List<String> names = new ArrayList<>(Arrays.asList("chris", "john", "bev"));
        // names.forEach((s) -> System.out.println(s));
        // names.forEach(System.out::println);
        // }

        // removeIf
        List<Integer> nums = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        nums.removeIf((n) -> n % 2 == 0);
        System.out.println(nums);

// streams

        List<String> words = Arrays.asList("one", "two", "three");
        words.forEach(System.out::println);

        List<String> x = words.stream()
                        .map(String::toUpperCase)
                        .toList();

        System.out.println(x);
                            
// Streams:
        // A sequence of elements that pass though a stream. 
        // Must originate from a data source.
        // Doesnt store or retain data. 
        // Single use.
        
        // lifecylce:
        //        - source:
              //  - collections: list.stream()
             //   - arrays: arrays.stream(arr)
            //    - files: Files.lines(path);
          // - intermdeiate steps:
          //  - map, filter, sorted, limit
          // - Terminal operation
           // - count, foreach, tolist, reduce. 

        // List<String> names = Arrays.asList("chris", "john", "bev");

        // long count = names.stream()
        //             .filter((n) -> n.length() > 3)
        //             .map(String::toUpperCase)
        //             .count();

        // System.out.println(count);

        // List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

        // int sum = nums.stream()
        //             .reduce(0, (a, b) -> a + b);

        // System.out.println(sum);


 */