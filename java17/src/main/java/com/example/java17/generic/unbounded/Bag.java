package com.example.java17.generic.unbounded;

import java.util.ArrayList;
import java.util.List;

// generic type
public class Bag<E> {

    private E element;
    private final List<E> logs = new ArrayList<>();

    public void add(E e) {
        if (e != null) {
            logs.add(e);
            element = e;
        }
    }

    public E getElement() {
        return element;
    }

    public Iterable<E> iterator() {
        return logs;
    }

}
