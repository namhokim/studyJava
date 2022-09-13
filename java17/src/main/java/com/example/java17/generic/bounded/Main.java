package com.example.java17.generic.bounded;

public class Main {
    public static void main(String[] args) {
        Bag<CharSequence> stringBag = new Bag<>();
        stringBag.add("123");
        stringBag.add(new StringBuilder("11111"));

        for (CharSequence it :stringBag.iterator()) {
            System.out.println(it.toString());
        }

        CharSequence elem = stringBag.getElement();
        System.out.println(elem);

        System.out.println(stringBag.getTotalLength());
    }
}
