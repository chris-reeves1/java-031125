package Bmethods;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.add(1, 2, 10);
    }

    public void add(int a, int b){System.out.println(a + b);}
    public void add(int a, int b, int c){System.out.println(a + b);}
    public void add(int c, int b, double a){System.out.println(a + b);}
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
 * 
 * 
 * 
 * 
 * 
 */
