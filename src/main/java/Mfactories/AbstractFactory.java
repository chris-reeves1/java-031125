package Mfactories;

public class AbstractFactory {
    public static void main(String[] args) {
        MealService service = new MealService(new JapaneseMealFactory());
        service.full();
    }
}

// interfaces for mainCourse, Drink, Dessert. (abstract for serve())
interface MainCourse { void serve();}
interface Dessert { void serve();}
interface Drink { void serve();}

class Pasta implements MainCourse{@Override public void serve(){System.out.println("serving pasta");}}
class Tiramisu implements Dessert{@Override public void serve(){System.out.println("serving tiramisu");}}
class Wine implements Drink{@Override public void serve(){System.out.println("serving wine");}}

class Sake implements Drink{@Override public void serve(){System.out.println("serving sake");}}
class Mochi implements Dessert{@Override public void serve(){System.out.println("serving mochi");}}
class Katsu implements MainCourse{@Override public void serve(){System.out.println("serving katsu");}}

// abstract interface factory set MainCourse, drink, dessert -- abstract method.  
interface MealFactorys{
    MainCourse createMain();
    Drink createDrink();
    Dessert createDessert();
}
// japanese factory
class JapaneseMealFactory implements MealFactorys {
    @Override public MainCourse createMain() {return new Katsu();}
    @Override public Drink createDrink() {return new Sake();}
    @Override public Dessert createDessert() {return new Mochi();}
}
class ItalianMealFactory implements MealFactorys {
    @Override public MainCourse createMain() {return new Pasta();}
    @Override public Drink createDrink() {return new Wine();}
    @Override public Dessert createDessert() {return new Tiramisu();}
}

// concrete implemntation.
class MealService{
    MealFactorys factory;

    public MealService(MealFactorys factory){
        this.factory = factory;
    }
    // template
    void full(){
        factory.createMain().serve();
        factory.createDrink().serve();
        factory.createDessert().serve();
    }
}
