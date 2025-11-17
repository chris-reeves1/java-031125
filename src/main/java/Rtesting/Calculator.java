package Rtesting;

public class Calculator {
    public int add(int a, int b) { return a + b; }

    public int div(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("b must not be zero");
        return a / b;
    }

    public int clamp(int value, int min, int max) {
        if (min > max) throw new IllegalArgumentException("min > max");
        return Math.min(Math.max(value, min), max);
    }
}