package org.example;

import java.util.ArrayList;

public abstract class Variable extends Value {

    /**
     * Fallback Multiplication even for incalculable values
     * @param n value which multiplies this variable
     * @return this variable multiplied by n
     */
    @Override
    public Value multiply(Value n) {
        this.factors.multiply(n.factors);
        return this;
    }

    @Override
    public Value divide(Value n) {
        this.factors.divide(n.factors);
        return this;
    }

    /**
     * Fallback Addition even for incalculable values
     * @param n value which is added to this variable
     * @return this variable with n added
     */
    @Override
    public Value add(Value n) {
        if (this.identifier.equals(n.identifier)) {
            this.factors.toSingleton();
            this.factors.set(0, (Term) this.factors.get(0).add(n.factors.toSingleton()));
            return this;
        } else {
            return new Term(
                    this,
                    (Variable) n
            );
        }
    }

    /**
     * Fallback Subtraction even for incalculable values
     * @param n value which is subtracted from this variable
     * @return this variable with n subtracted
     */
    @Override
    public Value subtract(Value n) {
        if (this.identifier.equals(n.identifier)) {
            this.factors.toSingleton();
            this.factors.set(0, (Term) this.factors.get(0).subtract(n.factors.toSingleton()));
            return this;
        } else {
            return new Term(
                    this,
                    (Variable) n.negate()
            );
        }
    }

    /**
     * High Level method for general Variable Inversion
     * | Fallback method, might only change the exponent to -1
     * @return inverse of Variable
     */
    @Override
    public Value inverse() {
        Variable buffer = this;
        buffer.potency = Integer.newInteger(1, true);
        return buffer;
    }

    /**
     * Negates this Variable
     * @return variable with flipped sign
     */
    @Override
    public Value negate() {
        Variable shadow = this;
        shadow.sign = !shadow.sign;
        return shadow;
    }

    /**
     * This is a high Level method for unspecified variable comparison
     * TODO: implement logic because String comparison is hacky
     * @param n value to compare to
     * @return truth value of equivalence
     */
    @Override
    public Boolean equals(Value n) {
        return this.identifier.equals(n.identifier);
    }

    /**
     * using this is only recommended if it is intended to change the
     * variable definition
     * @param o the value of this Variable gets replaced by o
     */
    @Override
    public void setValue(Object o) {
        this.value =  new ArrayList<>();
        this.value.add(o);
    }

    @Override
    public void selfPrint() {
        System.out.println(this);
    }
}
