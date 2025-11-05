package FTypes;

public class Main {
    public static void main(String[] args) {
        
        Person person = Person.createChild("chris");
        
        // Person person1 = new Person();
        // person1.introduce();
        // person1.setAge(1);
        // person1.setName("c");
        // person1.introduce();
        // System.out.println(person1.getAge());

         
    
    }
}


class Person{
    private String name;
    private int age;

    // private constructor
    private Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    //factory method
    public static Person createChild(String name){
        return new Person(name, 10);
    }
}







// class Person{
//     // fields - makes the state of an object.
//     private String name;
//     private int age;

//     // No param constructor
//     public Person(){
//     }
//     // constructor: paramatrized constructor
//     public Person(String name, int age){
//         this.age = age;
//         this.name = name;
//     }
//     // single-param constructors (optionally with default value)
//     public Person(String name){
//         this.name = name;
//         this.age = 18;
//     }

//     // methods - the potential behaviour of the object
//     public void introduce(){
//         System.out.println("name is " + name + " age is " + age);
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public int getAge() {
//         return age;
//     }

//     public void setAge(int age) {
//         if (age > 0){ //validation
//         this.age = age;}
//     }

    
// }

// class Engine{
//     public void start(){
//         System.out.println("Engine started");
//     }
// }

// class Car extends Engine {
//     // inherits start method from engine. 
// }

// class Engine{
//     public void start(){
//         System.out.println("Engine started");
//      }
//     }

// class Car{
//     private Engine engine;

//     // constructor
//     public Car(Engine engine){
//         this.engine = engine;
//     }

//     public void startCar(){
//         engine.start();
//         System.out.println("car is now running also");
//     }
// }

/* 
 * OOP/Types
 * ---------
 * 
 * - There are two types in Java:
 *      - primitives
 *      - Reference types
 * 
 *      - Differences:
 *          - What type of data
 *          - The actions that can be performed. 
 * 
 *     custom class example:
 * Person person1 = new Person();
        person1.name = "chris";
        person1.age = 30;
        person1.introduce();

    }
}

class Person{
    // fields - makes the state of an object.
    String name;
    int age;

    // methods - the potential behaviour of the object
    public void introduce(){
        System.out.println("name is " + name + " age is " + age);
    }
}
 * 
 * mutable vs immutable
 * --------------------
 * 
 * - immutable type: Once created cannot be changed (eg Strings)
 * - mutable: can be modified (eg custom objects (like Person))
 * 
 *  immutable example:
 *      String name = "something"
 *      name = name.toUpperCase() // creates a new object.
 * 
 *  Best practice:
 *  - Encapsulation: use private fields and provide getters/setters.
 *  - Avoid magic numbers - always initialise and declare meaningful vars.
 *  - Use meaningful names.
 * 
 *    eg: 
 * Person person1 = new Person();
        person1.introduce();
        person1.setAge(1);
        person1.setName("c");
        person1.introduce();
        System.out.println(person1.getAge());

    }
}

class Person{
    // fields - makes the state of an object.
    private String name;
    private int age;

    // methods - the potential behaviour of the object
    public void introduce(){
        System.out.println("name is " + name + " age is " + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0){ //validation
        this.age = age;}
    }

    
}

Comparing objects with Equals and ==
------------------------------------

primitives (ints, chars, bools), == checks if the values are the same.

eg 

        int a = 10;
        int b = 10;

        System.out.println(a == b); // true == compares values. 

For objects, == checks if both point to the same object in memory. 

.equals()

Compares the content of reference types (ie state of an object)
Some classes override the .equals to change its behaviour. 
(String, Integer, List are example that override)

Person person1 = new Person();
        Person person2 = person1;
        System.out.println(person1 == person2); // True - same heap object. 
        Person person3 = new Person();
        System.out.println(person1 == person3); // false - not same object
        System.out.println(person1.equals(person3)); // still false - not overriddewn by our class. 
    
        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1.equals(str2)); // Should be true - same content. 


Encapsulation:
-------------
 - Concept of restricting direct access to fields and methods.
 
 purpose:
  - Control internal state of an object.
  - control who and how data is accessed.
  - promotes modularity and single purpose design. 

Features:
    - private fields, no direct access.
    - controlled access through getters and setters. 

Abstraction:
------------
 - Concept of hiding implementation details.
 
 Purpose: 
 - Reduce complexity, by focusing on base structure. 
 - Allow developers to use objects without knowing the code/inner workings.

 - implementations:
    - abstacts
    - interfaces

Composition:
------------

without composition (inheritance):
 eg: 

 class Engine{
    public void start(){
        System.out.println("Engine started");
    }
}

class Car extends Engine {
    // inherits start method from engine. 
}
public static void main(String[] args) {
        

        Car car = new Car();
        car.start();

        -- THIS IS CREATED AN UNNATURAL HIERARCHY!

class Engine{
    public void start(){
        System.out.println("Engine started");
     }
    }

class Car{
    private Engine engine;

    // constructor
    public Car(Engine engine){
        this.engine = engine;
    }

    public void startCar(){
        engine.start();
        System.out.println("car is now running also");
    }
}
in main:
Engine Newengine = new Engine();
        Car car1 = new Car(Newengine);

        car1.startCar();


State
-----
- Determined by the fields. 
- accessors/mutators - getters/setters
- for immutability: 
    - keep things private
    - prefer Final. 
    - Careful with setter(validated) - prefer constructors. 

Constructors
------------

- Block of code/method called when an object is created.
- Provides the object with specific or default values.
- Default constructor is used if none provided by us. 

- A constructor has:
    - The same name as the class (exaclty)
    - No return type not even void.
    
Needed for:
    - Object initialisation
        provides values to fields.
    - Encapsulation of setup logic
        Centralise logic inside the class.
    - Make fields mandatory. 

constructor overloading:
- multiple can be defined - just change the params.
- multiple construction flows available. 

class Person{
    // fields - makes the state of an object.
    private String name;
    private int age;

    // No param constructor
    public Person(){
    }
    // constructor: paramatrized constructor
    public Person(String name, int age){
        this.age = age;
        this.name = name;
    }
    // single-param constructors (optionally with default value)
    public Person(String name){
        this.name = name;
        this.age = 18;
    }

Factory Method
--------------

- Returns an instance of a class.
- Decouples object creation from class logic.
- Improves readability/maintainability. 

class Person{
    private String name;
    private int age;

    // private constructor
    private Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    //factory method
    public static Person createChild(String name){
        return new Person(name, 10);
    }
}

- Benifits:
 - Encapsulation
 - flexible instantiation
 - readability
 - overloading confusion mitigated. 
 - improve testing

 disadvantages:
    - more complex
    - overhead
    - more to debug. 
*/