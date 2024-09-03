package org.example;

public class Rational extends Frac {

    private Rational(final Natural numerator, final Integer denominator) {
        super(numerator, denominator);
    }

    public static Rational newRational(int numerator, int denominator) {
       return new Rational(
               Natural.newNatural(numerator),
               denominator < 0 ? Integer.newInteger(Math.abs(denominator), true) : Integer.newInteger(denominator, false)
       );
    }
}
