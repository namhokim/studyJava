package com.example.java17.generic.unbounded;

public class Main {
    public static void main(String[] args) {
        Bag<String> stringBag = new Bag<>();
        stringBag.add("123");
        stringBag.add("11111");

        for (String it :stringBag.iterator()) {
            System.out.println(it.length());
        }

        final String element = stringBag.getElement();
        System.out.println(element);
    }
}
