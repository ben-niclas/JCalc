package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MultiplicativeSet {
    ArrayList<Term> factors;

    private MultiplicativeSet() {
        super();
    }

    private MultiplicativeSet(Term ... v) {
        Collections.addAll(factors, v);
    }

    public static MultiplicativeSet newMultiplicativeSet() {
        return new MultiplicativeSet();
    }

    public static MultiplicativeSet newMultiplicativeSet(Term ... v) {
        return new MultiplicativeSet(v);
    }

    public Boolean equals(MultiplicativeSet s) {
        for(Variable i : factors) {
            for (Variable j : s.factors) {
                if (!i.equals(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param v MultiplicativeSet which elements are added to this MultiplicativeSet
     *
     */
    public void multiply(MultiplicativeSet v) {
        factors.addAll((Collection<? extends Term>) v);
    }

    public Term toSingleton() {
        Term buffer = product();
        factors.clear();
        factors.set(0, buffer);
        return buffer;
    }

    public void set(int index, Term value) {
        factors.set(index, value);
    }

    /**
     * TODO: REVIEW: if removeAll removes All occurrences
     * @param v MultiplicativeSet of elements to be removed from this MultiplicativeSet
     */
    public void divide(MultiplicativeSet v) {
        factors.removeAll(Collections.singleton(factors.retainAll(v.factors)));
    }

    /**
     *
     * @return simplified Term of all factors
     */
    public Term product() {
        return null;
    }

    public Term get(int i) {
        return factors.get(i);
    }
}

