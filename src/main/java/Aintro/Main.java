package Aintro;

public class Main {
    public static void main(String[] args) {

        // int age; // primitive types - stored directly stack memory. 
        // age = 10;
        // String name = "chris"; // reference type (references an obj) -- stored in heap memory. 


        // int a = 5;
        // int b = a; // copys the value
        // b = 10;
        // System.out.println(a);
        // System.out.println(b);

        // // reference types (an object can have multiple references):
        // int[] arr = {1, 2, 3};
        // int[] ref = arr;

        // ref[0] = 100;
        // System.out.println(arr[0]);
        // System.out.println(ref[0]);

        // incrementation
        // ++pre  --  ++post 

        // // int i = 5;
        // // int result = ++i;
        // // System.out.println(i);
        // // System.out.println(result);

        // int i = 5;
        // int result = i++;
        // System.out.println(i);
        // System.out.println(result);

        // for (int i =0; i < 5; i++){
        //     System.out.println(i);
        // }

        // casting (explicit(narrowing) + implicit(widening))

        // int num = 100;
        // long l = num; // implicitly allowed.
        // System.out.println(l);

        // double d = 10.5;
        // int num = (int) d;

        // System.out.println(num); // truncated + loss of accuracy.
        
        // string to primitive parsing.

        // String intString = "123";
        // int number = Integer.parseInt(intString);
        // System.out.println(number);

        // String doubleString = "45.41";
        // double d = Double.parseDouble(doubleString);
        // System.out.println(d);

        // String boolString = "true";
        // boolean bool = Boolean.parseBoolean(boolString);
        // System.out.println(bool);
    }
}





/*
 * Oak 1991. 
 * 
 * jdk - developer kit - jvm + language tools
 * jre - run time env - just for running apps. 
 * 
 * Compiled language - complies to bytecode - JVM runs the bc. 
 * 
 * main method:
 * public static void main
 *      - public: access control - public can be called from anywhere.
 *                                 JVM needs it to be public.
 *      - static - no object is required. 
 *      - void - doesnt return anything.
 *      - main - just a name.
 * - args - pass through at run time.  
 * 
 * 
 * naming convention: 
 *  - Always start with a letter.
 *  - Dont use reserved words.
 *  - classes: PascalCase
 *  - methods/variables: camelCase
 *  - snake_case optional. 
 *  - USE WITH CONSISTANCY!! 
 *  - be descriptive. 
 * 
 * 
 *  Variables: 
 *  - primitive types
 *  - reference types
 *  - declare with a type.
 *  - initialise with a value. 
 * 
 *  primitives:
 *  - incrementation, casting, parsing. 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
*/