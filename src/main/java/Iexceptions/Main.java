package Iexceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {level1();}catch(ArithmeticException e){System.out.println(e.getMessage());}
    
    }

        public static void level1(){
            level2();
        }

        public static void level2(){
            level3();
        }

        public static void level3(){
            int result = 10 / 0; // be granular at this level
        }


}




/*

Exceptions:
    - mechanism to handle run time errors
    - allows normal flow to continue.
    - try-catch-finally block. throw/throws
    - try-with

Types:
    checked exceptions: must be dealt with before we complie with 
                        throw/throws or try/catch.
        - sqlexceptions
        - ioExceptions

    unchecked exceptions:
        - Occur runtime and not caught by the complier.
        - outofbounds exception
        - arthimiticException
    
    errors: 
        - Represents problems that we cant deal with (memory)


syntax:

try{
    code that might throw an exception - if multi the first is taken
    Further code in a try block is skipped.
} catch (ExceptionType e) {
    optionally print or log - sys.print("[ERROR] Cant divide by zero" + e.getmessage())
} catch (ExceptionType2 e) {
    optional print/log} 
    catch (Exception e) {
    log} finally {
    clean-up operation}


checked:

try{
        FileReader file = new FileReader("nonexistantfile.txt");
        } catch (FileNotFoundException e){
            System.out.println("[ERROR] File not found - details: " + e.getMessage());
        } finally{
            System.out.println("logging...");
        }

UNCJECKED: 

try {
        int result = 10 / 0;
        String p = null;
        System.out.println(p.length()); // null pointer exception 
      } catch(ArithmeticException e){
        System.out.println("[ERROR] Zero division error occured. - Details: " + e.getMessage());
      } catch (NullPointerException e){
            System.out.println("ERROR" + e.getMessage());
      } 

throw/throws

AgeValidator validator = new AgeValidator();
        try{
            validator.validatAge(17);}
            catch(InvalidAgeException e){
                System.out.println(e.getMessage());
            }
      
     }
}
class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }
}

class AgeValidator{
    public void validatAge(int age) throws InvalidAgeException{
        if (age < 18){
            throw new InvalidAgeException("Age must be over 18");
        }
        System.out.println("age passed validation");
    }
}


Try-with: anything that implements the closeable interface can use the with
            clause. 

 syntax:
        try (resourceType name = new resourceType(??)){
            block ofd code to try
        } catch (){}
         finally{}

try(BufferedReader reader = new BufferedReader(new FileReader("nonexistant.txtx")))
        {String l;}
        catch(IOException e){}


Propogation - bubbling up

- when exception occurs java looks for a catch block to handle it.
- if not cuaght by the current calling method, 1) error out 2) pass on to a higher calling method.
- if reaches main method its either dealt with there or break flow. 


public static void main(String[] args) {
        try {level1();}catch(ArithmeticException e){System.out.println(e.getMessage());}
    
    }

        public static void level1(){
            level2();
        }

        public static void level2(){
            level3();
        }

        public static void level3(){
            int result = 10 / 0; // be granular at this level
        }
 */