package Bmethods;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // printf .format
        System.out.printf("integer: %d%nString: %s%nFloat: %.2f", 10, "hello", 10.5);

        String name = "chris";
        int age = 10;
        double x = 10.5;

        String l = String.format("%s%n%d%n%.2f", name, age, x);
        System.out.println(l);
    }
}











/* methods + inputs + printf/.format
 * 
 * Methods:
 *  - A block of code that is repeatable.
 *  - A method must be inside a class.
 *  
 *  signature:
 *      -  access_modifiers:
 *              - public: accessible from anywhere.
 *              - protected: accessibly only in the same package or subclasses.
 *              - private: class only. 
 *              - default (empty): package-protected - package only. 
 *  return type:
 *              - void (no return type)
 *              - type (int, obj, string)
 * 
 *  params: 
 *          - Can be none -- void greet(){}
 *          - can be single: void greet(String name){}
 *          - multiple: void greet(String name, int age){} 
 * 
 *  object creation:
 *      type name = new type()
 *      Obj obj = new Obj()
 * 
 *  overloading:
 *      - Multiple methods all using the same name.
 *      - must have diff params:
 *              - types of
 *              - number of    
 * 
 *  eg:
 * 
 * Main m = new Main();
        m.add(1, 2, 10);
    }

    public void add(int a, int b){System.out.println(a + b);}
    public void add(int a, int b, int c){System.out.println(a + b);}
    public void add(int c, int b, double a){System.out.println(a + b);}
}
 * 
 * inputs:
 * 
 * Scanner scanner = new Scanner(System.in);

        System.out.println("enter your name: ");
        String name = scanner.nextLine(); // reading entire line of input (string)

        System.out.println("enter your age: ");
        int age = scanner.nextInt(); 
       
        System.out.println("enter a double: ");
        double d = scanner.nextDouble();

        scanner.nextLine();

        System.out.println("enter a string: ");
        String n = scanner.nextLine();

        System.out.println("hello " + name + " age is " + age + " double is " + d + " string is " + n);

        scanner.close();


        Scanner scanner = new Scanner(System.in);

        System.out.println("enter age: ");
        int age = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("enter a string: ");
        String n = scanner.nextLine();

        System.out.println("age is " + age + " string is " + n);
        scanner.close();
 * 
 * 
 */
