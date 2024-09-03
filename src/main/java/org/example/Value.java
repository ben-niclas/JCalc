package org.example;

import java.util.ArrayList;
import java.util.Set;

public abstract class Value {
    protected Boolean sign = null;
    protected ArrayList<Object> value = null;
    protected Term potency = null;
    protected Boolean finite = true;
    protected MultiplicativeSet factors;
    protected String identifier;

    public abstract Value multiply(Value n);

    public abstract Value divide(Value n);
    public abstract Value add(Value n);
    public abstract Value subtract(Value n);

    public abstract Value inverse();
    public abstract Value negate();

    public abstract Boolean equals(Value n);

    public abstract String toString();
    public abstract String toStringAbs();
    /**
     * prints the toString() value and adds a newline
     */
    public abstract void selfPrint();

    abstract void setValue(Object o);
}
