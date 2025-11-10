package Kabstracts;

public class Main {
    public static void main(String[] args) {
        DataProcess dp = new JsonProcess();
        dp.process();
    }
}

abstract class DataProcess{
    // template method
    public final void process(){
        statusCheck();
        readData();
        transformData();
        saveData();
        logOutcome();
    }

    public void statusCheck(){
        System.out.println("file found and reader ready...");
    }

    public void logOutcome(){
        System.out.println("Outcome logged...");
    }

    abstract void readData();
    abstract void transformData();
    abstract void saveData();

}

class JsonProcess extends DataProcess{

    @Override
    void readData() {
        System.out.println("data read...");
    }

    @Override
    void transformData() {
        System.out.println("data transformed...");
    }

    @Override
    void saveData() {
      System.out.println("data saved...");
    }
    
}




/*
 
Abstracts:
    - Abstract class cant be initialised.
    - Declare with the abstract keyword
    - Abstract (bodyless) methods or concrete methods. 
    - abstract implementation must be done in a sub-class.
    - Allows stronger hierarchical design, more detailed blueprint.

    - shared state, common methods and properties given to all child classes.
    - forcing behaviour.

benifits to design:
    - enforce contracts
    - enusre specific/important behaviour can be delegated.
    - Allows code resuse in concretes.
    - fliexibility. 

problems:
 - tight coupling.
 - less modular. 
 - scalability?? complexity/maintainability.

 problems with concretes:
 - cant enforce behaviour.
 - instaniation is allowed but often dangerous.
 - Coupling. 


basic examples:
        abstract class Animal{ // technically an incomplete class. 
        abstract void sleep(); //bodyless!! 
    }

    class Dog extends Animal{
        @Override
        void sleep(){
            System.out.println("sleeping...");
        };
    }


abstracts + concretes:
    public class Main {
    public static void main(String[] args) {
        
    }
}

abstract class Vehicle{
        abstract void drive();
        void beep(){
            System.out.println("something....");
        }
    }

    class Car extends Vehicle{
        @Override
        void drive(){};

    }

abstracts vs interfaces:
                        abstracts       interfaces
inststantiation:            no              no
constructors:               yes             no
fields:           yes(control of access)    CONSTANTS only
methods:             abstract/concrete      abstract/concrete
inheritance:         only extend once       implements many

    // interfaces: public fial static class.

advanced rules for abstract methods:
    - return types:
        - primitives: no variance allow. (circumvent with wrapper classes)
        - ref types: Orignal or a sub-type. 

        Override rules:
            - Access can be more permissive (eg protected to public ok.)
            - checked exceptions can become more narrow not broader. Unchecked doesnt matter.

eg abstract to abstract to concrete:
            abstract class Vehicle{
            abstract void drive();
            abstract void brake();
        
        }

        abstract class Car extends Vehicle{
            @Override
            void drive(){
                System.out.println("car drives");
            };
        }

        class ElectricCar extends Car{
            @Override
            void brake(){};
        }

simple template method:
















 */
