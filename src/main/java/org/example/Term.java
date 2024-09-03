package org.example;

import java.util.Collections;

    /**
     * Terms represent abstractions of sums that cannot be simplified
     * Therefore the elements of a term (in value) have to be treated like
     * additive entities
     */
public class Term extends Variable {
    public Term(Variable... v) {
        Collections.addAll(value, v);
    }

    public Boolean equals(Value t) {
        // REVIEW:
        // TODO:
        return false;
    }

    public Boolean equals(Term t) {
        if (value.size() != t.value.size()) {
            return false;
        }
        for (Object i : value) {
            for (Object j : t.value) {
                if (!i.equals(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Value multiply(Value n) {
        return null;
    }

    @Override
    public Value divide(Value n) {
        return null;
    }

    
    @Override
    public Value add(Value n) {
        return null;
    }

    @Override
    public Value subtract(Value n) {
        return null;
    }

    @Override
    public Value inverse() {
        return null;
    }

    @Override
    public Value negate() {
        return null;
    }

    @Override
    public String toString() {
        return identifier;
    }

    @Override
    public String toStringAbs() {
        return toString();
    }

    @Override
    public void setValue(Object o) {

    }
}
