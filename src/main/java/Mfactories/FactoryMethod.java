// // scalability: 2
// // maintainability: 2
// // efficiancy: 2


// package Mfactories;

// public class FactoryMethod {
//     public static void main(String[] args) {
//         Resturant r = new PastaResturant();
//         r.serveCustomer();
//     }
// }
// // abstract class 
// abstract class Meal{abstract void serve();}
// // extends with options
// class Pizza extends Meal {void serve(){System.out.println("serving pizza");};}
// class Pasta extends Meal {void serve(){System.out.println("serving pasta");};}

// abstract class Resturant{
//     protected abstract Meal createMeal();
    
//     // template method 
//     public void serveCustomer(){
//         Meal meal = createMeal();
//         meal.serve();
//     }
// }
// class PastaResturant extends Resturant {protected Meal createMeal(){return new Pasta();}}
// class PizzaResturant extends Resturant {protected Meal createMeal(){return new Pizza();}}



