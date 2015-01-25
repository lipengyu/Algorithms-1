package com.zhdan.algorithms;

import java.util.Comparator;

/**
 * Class for storing pairs of objects
 *
 * @author Egor Zhdan
 */
public class Pair<F, S> {

    public F first;
    public S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public static class NativeOrderComparator<F extends Comparable<F>, S extends Comparable<S>> implements Comparator<Pair<F, S>> {
        @Override
        public int compare(Pair<F, S> o1, Pair<F, S> o2) {
            if (o1.first.equals(o2.first)) {
                return o1.second.compareTo(o2.second);
            }
            return o1.first.compareTo(o2.first);
        }
    }

    public static class ReversedOrderComparator<F extends Comparable<F>, S extends Comparable<S>> implements Comparator<Pair<F, S>> {
        @Override
        public int compare(Pair<F, S> o1, Pair<F, S> o2) {
            if (o1.first.equals(o2.first)) {
                return -o1.second.compareTo(o2.second);
            }
            return -o1.first.compareTo(o2.first);
        }
    }

}
