package Genums;

public class Main {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("hello");
        sb.append(" world");
        sb.insert(5, ",");
        sb.replace(0, 5, "hi");
        sb.reverse();
        System.out.println(sb.toString());

    }
}



/*
 
Enums:
    - A data type that allows us to define a set of CONSTANTS. 
    - Gives us a menu of fixed options. Prevent misuse, misspelling of the constants.
    - Always implicitly public, final, static.
    
    Why:
    - type safety.
    - built-in methods.
    - Built-ins can be be overridden(inheritance).
    - We can add our own methods.

 eg:

    printDay(Day.MONDAY); // valid 
        //printDay(5); // wont compile
        for (Day day : Day.values()){
            System.out.println(day);
        }

        Day today = Day.FRIDAY;

        switch (today){
            case MONDAY -> System.out.println("start of week ops..");
            case FRIDAY -> System.out.println("end of week ops...");
            default -> System.out.println("not mon or fri");
        }

    }
    public static void printDay(Day day){
        System.out.println(day);
    }

limitiations:
    - Extends java.lang.enum - cant extend again (limited to 1).
    - Heavy construct - compuationally heavy - makes a whole class. 
 rough example of the compiled class:
        
            public final class Day extends Enum{
            
            public final static Day MONDAY = new Day("MONDAY", 0) 
            public final static Day TUESDAY = new Day("TUESDAY", 1) 
            public final static Day WEDNESDAY = new Day("WEDNESDAY", 2) 
            public final static Day THURSDAY = new Day("THURSDAY", 3) 

            private Day(String name, int ordinal){
                super(name, ordinal)

            public static Day[] values[]{.....}
            public static valuof(name){.......}
            }
            }
    
Directions: inbuilt overides: 
Direction d = Direction.NORTH;

    System.out.println(d.name()); // NORTH
    System.out.println(d == Direction.NORTH); // true 
    System.out.println(d.equals(Direction.SOUTH)); // False

    for (Direction y : Direction.values()){
        System.out.println(y.name() + ": " + y.ordinal());
    }

    System.out.println(d); // overridden toString ie North
    System.out.println(Direction.NORTH); // same....
    System.out.println(Direction.NORTH.name()); // NORTH

Strings + String builder
------------------------

- Common data type
- Immutable (any operation results in a new string being made)
- Why not primitive? - complexity + flexibility required.
- system optimizations - research it! 

 - Strings:
    comparrsion:
        ==, .equals, compareTo
    Transformational:
        trim(), toUpperCase()
    Searching:
        contains(), indexOf()
    substrings:
        substring()
    splits/joins

String builder:
- avoid the inefficiancy of creating new objects
- StringBuilder is a mutable class - allows string manipulation to occur. 

basic method:
- append()
- insert()
- delete()
- replace()
- reverse()
    


















*/