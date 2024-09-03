package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Integer extends Num {

    private Integer(final java.lang.Integer value, final Boolean sign) {
        this.value = new ArrayList<>(Collections.singletonList(value));
        this.sign = sign;
        this.identifier = String.valueOf(value.intValue());
    }

    public static Integer newInteger(int value, Boolean sign) {
        return new Integer(value, sign);
    }

    public static Integer newInteger() {
        return new Integer(0, false);
    }

    @Override
    public String toString() {
        return (sign ? "-" : "") + identifier;
    }

    public String toStringAbs() {
        return "" + identifier;
    }

}
