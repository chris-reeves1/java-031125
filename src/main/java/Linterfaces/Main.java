package Linterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       List<Person> person = new ArrayList<>();
       person.add(new Person(60, "a"));
       person.add(new Person(80, "b"));
       person.add(new Person(40, "c"));
       
       Collections.sort(person);
       for (Person x : person){
        System.out.println(x.getAge() + " " + x.getName());
       }
    }


}

class Person implements Comparable<Person> {
    private int age;
    private String name;

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person x) {
        return Integer.compare(this.age, x.age);
    }
}



/*

Interfaces:
- Helps to achieve more abstraction, contracts of behaviour.
- Defines shared behaviour that can be implemeted by any class regardless of
    class hierarchy.

relationships:
    - abstracts/super/any: "is-a"
    - composition: "uses"
    - interfaces: "can-do"

Why use interfaces:
        - abstraction
        - decoupled behaviour
        - multiple implementations. 

Basic design:
    - abstracts - empty methods (bodyless)
    - default methods - regular static methods.
    - Holds CONSTANTS. implicitly final, public, static.

implementation:
        - keyword: implements 
        - class must implement, provide concrete code for the abstracts.
        - defaults are optional to use or not.
        - seperation principle - smaller over few larger ones.



basic example:
        class Airplane implements Flyable {
        @Override
        public void fly(){
                System.out.println("flying...");
            }
        }


        class Drone implements Flyable, Operable {
            @Override
            public void fly(){
                System.out.println("flying...");
            }
            @Override
            public void operate(){
                System.out.println("operating...");
            }
        }


with defaults:
        class Dog implements Animal {
            @Override
            public void eat(){
                System.out.println("eating...");
            }
        }

        class Cat implements Animal {
            @Override
            public void eat(){
                System.out.println("eating...");
            }
            @Override
            public void sleep(){
                System.out.println("sleeping...");
            }
        }

Multiple interfaces:
 - If a class implements multiple with the same method names - the class
        must decide which one to use.
 - If the name is the same as an inherited abstract method the parent class
    will take precedence. 

 example:

        class MyClass implements A, B {
    @Override
    public void show(){
        A.super.show();
        System.out.println("custom implemenation also!!");
    }
}

Naming convention:
    - the name should indicate the behaviours.
    - Adjective, verbs
    - Use "I" to preceed interface names like Iinterface. 


strategy pattern /dependancy injection:

public static void main(String[] args) {
        Logger logger = new ConsoleLogger();
        App app = new App(logger);
        app.run();

        ShoppingCart cart = new ShoppingCart(new CreditCardPayment());
        cart.checkout(200);

    }
}

class ConsoleLogger implements Logger {
    @Override
    public void log(String message){
        System.out.println("[LOG] - " + message);
    }
}

class App {
    private final Logger logger;

    public App(Logger logger){
        this.logger = logger;
    }

    public void run(){
        logger.log("application is running");
    }
}


class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount){
        System.out.println("paid  " + amount + " with credit card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount){
        System.out.println("paid  " + amount + " with Paypal.");
    }
}

class ShoppingCart {
    private PaymentStrategy strategy;

    public ShoppingCart(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void checkout(int amount){
        strategy.pay(amount);
    }
}


Marker interfaces:

- Tagging/markng a class with an empty interface.
- Acts as a flag/tag/metadata.
- class myclas implements serializable {}
- class myclass implemtns Clonable {}

- Replaced by annotations. 

Functional inerfaces:
 - an interface that has just one abstract method. 
 - SAM (single abstract method)
 - @functionalInterface - just checks for multuiple abstracts.
 - lets us implement lambda expressions. 

 - Power lambda, streams, method references, event handling, modern API style
 - Flexible, expressive. 

    // lambda expressions implement the interface
        Operation add = (a, b) -> a + b;
        Operation multiply = (a, b) -> a * b;

        System.out.println(add.apply(3, 4));

Generic interfaces:

- type safety
- Resuability + flexibility

syntax:
    public Container <T> {
    void add {T item}
    T gettr();
    }

    IntergerContainer ic = new IntergerContainer();
        ic.add(10);
        System.out.println(ic.get());

        GenericContainer<String> gc = new GenericContainer<>();
        gc.add("ten");
    }
}

class GenericContainer<T> implements Container<T>{
    private T item;

    @Override
    public void add(T item){
        this.item = item;
    }

    @Override
    public T get(){
        return item;
    }
}

class IntergerContainer implements Container<Integer>{
    private int item;

     @Override
    public void add(Integer item){
        this.item = item;
    }

    @Override
    public Integer get(){
        return item;
    }

in built interfaces:
    - 100's of in builts! - just learn a few.
    - Comparable:
        - class implements - objects can be compared and we can define an order.
        - smallest largest.
        - useful for sorting. 






















 */
