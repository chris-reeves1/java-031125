//scalability (0-3) - 1
//maintainability (0-3) - 1
//efficiancy (0-3) - 1



package Mfactories;

public class SimpleFactory {
    public static void main(String[] args) {
        Meal meal = MealFactory.getMeal("pizza");
        meal.serve();
}
}

abstract class Meal{
    abstract void serve();
}

// 2 x extending the abstract class

class Pizza extends Meal {
    void serve(){System.out.println("serving pizza");};
}
class Pasta extends Meal {
    void serve(){System.out.println("serving pasta");};
}

//factory (conditional logic to see what to serve. )
class MealFactory {
    static Meal getMeal(String type){
        if("pizza".equalsIgnoreCase(type)){return new Pizza();}
        if("pasta".equalsIgnoreCase(type)){return new Pasta();}
        throw new IllegalArgumentException("must be pizza or pasta");
    }
}



/*
simple-factory: uses if/switches  +  hides new()   
factory-method: delegates to subclasses + defer to a subclass
abstract-factory: families of obj.   



rate out of 0-3 for scalability, maintainability and efficiancy. 
 */