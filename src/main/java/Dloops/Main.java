package Dloops;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // For loops
        // basic loop:

        // for (initialisation; condition; increment){
        //     code block
        // }

        for (int i = 1; i < 3; i++){
            System.out.println("count = " + i);
        }
        
        // enhanced for loop:
        // loops through an iterable

        // for(type element/item: collection/array){
        //     code block
        // }

        int[] numbers = {1, 2, 3, 4, 5};

        for (int number:numbers){
            System.out.println("number: " + number);
        }

        // infinites:
        // while(true)
        // for(;;) 

        // break and continue
        
        for (int i = 1; i < 10; i++){
            if(i == 5) break;
            System.out.println("i: " + i);
        }

        for (int i = 1; i < 10; i++){
            if(i == 5) continue; // go onto next iteration. 
            System.out.println("i: " + i);
        }         
    }
}



/*
 * loops:
 *  - repeatedly executes a block of code whilst a condition is true.
 *  - Loops need a conditiion to be met to start. 
 * 
 *  while, do-while, basic for, for each.  
 * 
 * while loop syntax: 
 * 
 * // while loop
        int i = 1; // counter 

        while(i < 5){
            System.out.println(i);
            i++;
        }
 * 
 * //do-while loop
        // Executed at least once even if associated condition is not true. 

        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while(i <= 5);

        // validation
        Scanner sc = new Scanner(System.in);
        int number;

        do {System.out.println("Enter a positive number: ");
            number = sc.nextInt();
            } while (number <= 0);
 * 
 * 
 * // menu with do-while
        Scanner sc = new Scanner(System.in);
        int choice;

        do {System.out.println("1. addition");
            System.out.println("2. subtraction");
            System.out.println("3. exit");
            System.out.println("Enter a choice: 1, 2, or 3");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("you chose add");
                    break;
                case 2:
                    System.out.println("subtracting....,");
                    break;
                case 3:
                    System.out.println("exiting...");
                    break;
                default:
                    System.out.println("invalid choice");
            }
        } while(choice != 3);
    }

    // break and continue
        
        for (int i = 1; i < 10; i++){
            if(i == 5) break;
            System.out.println("i: " + i);
        }

        for (int i = 1; i < 10; i++){
            if(i == 5) continue; // go onto next iteration. 
            System.out.println("i: " + i);
 */