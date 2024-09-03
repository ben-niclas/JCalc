package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Natural extends Num {

    private Natural(final int i) {
        this.value = new ArrayList<>(Collections.singletonList(i));
        this.sign = false;
        this.identifier = String.valueOf(i);
    }

    public static Natural newNatural(int i) {
        return new Natural(i);
    }

}
