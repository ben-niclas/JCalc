package org.example;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Integer.newInteger(5, true).selfPrint();
        Rational r = Rational.newRational(1, -2);
        r.selfPrint();
        r.inverse().selfPrint();
    }
}