package Earrays;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        
        // int[] numbers = {10, 20, 30};

        // numbers[0] = 100;

        // length
        // System.out.println(numbers.length);

        // // iterating over an array

        // for (int i = 0; i < numbers.length; i++){
        //     System.out.println(numbers[i]);
        // }

        // for(int num:numbers){
        //     System.out.println(num);
        // }

        // multi-dimensional arrays

        // int[][] matrix = {
        //     {1, 2, 3},
        //     {4, 5, 6},
        //     {7, 8, 9}
        // };

        // System.out.println(matrix[1][2]);

        // for(int i = 0; i < matrix.length; i++){
        //     for(int j = 0; j < matrix[i].length; j++){
        //         System.out.println(matrix[i][j]);
        //     }
        // }


         // copy
         
         int[] source = {1,2,3};
         int[] destinaton = new int[source.length];

        // for(int i = 0; i < source.length; i++){
        //     destinaton[i] = source[i];
        // }

        // System.out.println(destinaton[2]);

        int[] copy = Arrays.copyOf(source, source.length);
        






    }
}


/*
 * Arrays:
 *  - collection of values
 *  - must be of the same type. 
 *  
 *  syntax:
 *      // declaring:
 *      int[] arrayInt; // common way
 *      type arrayType[] // both valid
 *      
 *      // declare and initiatlise the length
 *      int[] arrayint = new int[5] (0,0,0,0,0)
 *      int[] arrayint = {10, 12, 15} //literal - ie with its data. 
 *      
 * characterisits:
 *  - fixed length
 *  - zero-based indexing
 *  - Only one data type but all are fine.
 *  - no own built-in methods
 *  
 * in memory:
 *  - Contiguous memory made in heap. (obj)
 *  - primitives in heap.
 *  - refs only have their ref stored (not the object)
 * 
 * defaults:
 *  int: 0
 *  boolean: false
 *  floats: 0.0
 *  obj: null
 *  char: u/0000
 * 
 * Why use:
 *  - Speed plus predictable performance.
 *  - memory efficiancy
 *  - Legacy code. 
 *  - Best for primitives. 
 *  - be aware of outofbounds errors. 
 * 
 * 
 * 
 * 
 */