package com.airport.management.model;

public class Calculator {
    public static void main(String[] args) {
        System.out.println(performCalculation(2,4,4));
    }
    public static int performCalculation(int a, int b, int c) {
        int d = 4;
        try {
            if (a == 2) {
                throw new Exception("Cannot call this with a == 2");
            }
            if (b == 4) {
                throw new Exception("Cannot call this with b == 4");
            }
            d = 5;
        } catch (Exception e) {
            System.out.println("Failed to execute method");
        }
        return a+b+c+d;
    }

}
