package com.example.java17.generic.bounded;

import java.util.ArrayList;
import java.util.List;

// bounded type parameter
public class Bag<E extends CharSequence> {
    private E element;
    private final List<E> logs = new ArrayList<>();
    private long totalLength = 0;

    public void add(E e) {
        if (e != null) {
            logs.add(e);
            element = e;
            totalLength += e.length();
        }
    }

    public E getElement() {
        return element;
    }

    public Iterable<E> iterator() {
        return logs;
    }

    public long getTotalLength() {
        return totalLength;
    }

}
