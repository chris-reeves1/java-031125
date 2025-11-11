package Linterfaces;

public interface Animal {
    default void sleep(){
        System.out.println("sleeping...");
    }
    void eat();
}
