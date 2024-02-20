package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + multiply(y) + divide(y);
    }

    public static void main(String[] args) {
        int sum = Calculator.sum(10);
        System.out.println(sum);
        int minus = minus(15);
        System.out.println(minus);
        int multiply = new Calculator().multiply(5);
        System.out.println(multiply);
        int divide = new Calculator().divide(30);
        System.out.println(divide);
        int sumAllOperation = new Calculator().sumAllOperation(5);
        System.out.println(sumAllOperation);
    }
}
