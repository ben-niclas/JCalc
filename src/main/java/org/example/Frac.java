package org.example;

public class Frac extends Variable {
    Term numerator;
    Term denominator;

    public Frac(final Term numerator, final Term denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Value multiply(Frac n) {
        return new Frac(
                (Term) this.numerator.multiply(n.numerator),
                (Term) this.denominator.multiply(n.denominator)
        );
    }

    @Override
    public Value divide(Value n) {
        return null;
    }

    public Value divide(Frac n) {
        return new Frac(
                (Term) this.numerator.multiply(n.denominator),
                (Term) this.denominator.multiply(n.numerator)
        );
    }

    public Value add(Frac n) {
        return new Frac(
                (Term) this.numerator.multiply(n.denominator).add(n.numerator.multiply(this.denominator)),
                (Term) this.denominator.multiply(n.denominator)
        );
    }

    @Override
    public Value inverse() {
        Frac inverse = new Frac(this.denominator, this.numerator);
        //inverse.sign = !this.numerator.sign;
        return inverse;
    }

    public Frac negate() {
        Term newDenominator = (Term) this.denominator.negate();
        return new Frac(this.numerator, newDenominator);
    }

    public Boolean equals(Frac n) {
        return this.denominator.equals(n.denominator)
                & this.numerator.equals(n.numerator);
    }

    @Override
    public String toString() {
        return (denominator.sign ? "-" : "") + "(" + numerator.toString() +  "/" + denominator.toStringAbs() + ")";
    }

    @Override
    public String toStringAbs() {
        return "(" + numerator.toString() +  "/" + denominator.toStringAbs() + ")";
    }

    public Value subtract(Frac n) {
        return this.add(n.negate());
    }

    @Override
    public void setValue(Object o) {

    }
}
