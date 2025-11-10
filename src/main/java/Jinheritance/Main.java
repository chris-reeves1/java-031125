package Jinheritance;

public class Main {
    public static void main(String[] args) {

        BankAccount ac = new BankAccount();
        try{
            ac.withdrawal(200);
        } catch (BankingException e){
            System.out.println(e.getMessage());
        }

        try{
            ac.accessAccount("user");
        } catch(BankingException e){
            System.out.println(e.getMessage());
        }

    }}


class BankingException extends Exception{
    public BankingException(String message){
        super(message);
    }
}

class InsufficientFundsException extends BankingException{
    public InsufficientFundsException(String message){
        super(message);
}
}

class UnauthorisedAccessException extends BankingException{
    public UnauthorisedAccessException(String message){
        super(message);
}
}

class BankAccount{
  private double balance = 100;
  
  public void withdrawal(double amount) throws BankingException{
    if (amount > balance) {
        throw new InsufficientFundsException("not enough money");}
  }

  public void accessAccount(String role) throws BankingException{
        if (!role.equals("admin")){
            throw new UnauthorisedAccessException("not allows");
        }
  }
}









/*

Inheritance:

    syntax:

    class SuperClass {
    // attributes, constructors, methods
    }

    class subclass extends Superclass {
    // additional fields, constructors, methods
    }

Note: Final classes cannot be extended.
      Final methods cannot be overridden. 

rules:
- classes can only extend once.
- Automatically inherit all methods and attributes of the superclass.
- Constructors not inherited but call with super().
- prefer shallow inheritance - No deep chains. 
- prefer composition - "has-a" over "is-a".
- always(mostly) have toString. 

- All classes extend Object - gives us toString, haschcode(), equals()...


What can a subclass do?
- inherits
- Access to fields and methods depending on modifiers.
- Use of methods + ability to override.
- override - use @override annotation
    - ensures we are corrctly chaning the super.

    Basic example:
        public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "doggo";
        dog.bark();
        dog.eat();

    }
}

class Animal{
    protected String name;

    public void eat(){
        System.out.println(name + " is eating");
            }
        }

        class Dog extends Animal{

            public void bark(){
                System.out.println(name + "barks");
            }
        }

        basic with override:

        Car car = new Car();
                car.speed = 100;
                car.displaySpeed();
                car.displaySpeedSuper();
            }}


        class Vehicle{
            protected int speed;

            public void displaySpeed(){
                System.out.println("speed is: " + speed);
            }
        }


        class Car extends Vehicle{

            @Override
            public void displaySpeed(){
                System.out.println("Cars speed: " + speed);
            }

            public void displaySpeedSuper(){
                super.displaySpeed();
            }
        }

Fields:

- inherited fields:
    - inherit all (except private fields), Access will depend on methods.
    - public: accessible everywhere
    - protected: package-wide + any sub-class
    - default: Package only.
    - private: not accissble.

- Shadowing - Using the same names for fields between super and sub classes.
              Super.attr_name to explicitly refer to the parent. 

- constructors:
    - not inherited.
    - need to call with super()
    - first arg in a constructor chain should be this() or super().
    - if not explicitly called the default constructor is called -uses defaults.

    examples:

    public static void main(String[] args) {
            Dog dog = new Dog("j");
            dog.displayName();
        }}


    class Animal{
        protected String name;

        public Animal(String name){
            this.name = name;
        }
    }

    class Dog extends Animal{
        protected int age;

        public Dog(String name){
            this(name, 1);
        }

        
        public Dog(String name, int age){
            super(name); // always goes first.
            this.age = age;
        }
        
        public void displayName() {
            System.out.println(name);
        }
    } 

substitutuion
- subtypes must be substitutable for the parent - without altering
    the correct flow of your app. 
- flexibility - adaptable to future changes.
- reusability - write generic code.
- abstraction.

example:
    Animal animal = new Dog(); // implicit casting - always ok.
        animal.speak(); // overridden methods always take precedence.
        //animal.testMethod(); // animal ref cant see the dog methods.
        //Animal mydog = new Dog();
        Dog mydog = (Dog) animal; // explicit casting - is it safe? 

        System.out.println(animal instanceof Dog);
    }}


class Animal{
    public void speak(){
        System.out.println("animal is speaking...");
    }
    }

class Dog extends Animal{
    @Override
    public void speak(){
        System.out.println("dog is speaking");
    }

    public void testMethod(){
        System.out.println("will this print!?");
    }
}
public static void main(String[] args) {
        
        Animal[] animals = {new Dog(), new Cat(), new Dog()};

        for (Animal a : animals){
            a.speak();
            a.animalOnly();
        

        if (a instanceof Dog){
            Dog d = (Dog) a;
            d.fetch();
        }
    }

    }}


class Animal{
    public void speak(){
        System.out.println("animal is speaking...");
    }
    public void animalOnly(){
        System.out.println("animal does something...");
    }
    }

class Dog extends Animal{
   @Override 
   public void speak(){
        System.out.println("Dog is speaking...");
    }
    public void fetch(){ // this needs to be called rarely
        System.out.println("Dog is fetching");
    }
}

class Cat extends Animal{
    @Override
    public void speak(){
        System.out.println("Cat is speaking...");
    }
    public void sitting(){
        System.out.println("cat is sitting");
    }
}















 */