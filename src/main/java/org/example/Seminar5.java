package org.example;

import java.util.HashMap;
import java.util.Map;

public class Seminar5 {

    public static void main(String[] args) {

        Map<Integer, String> coll = new HashMap<>();
        coll.put(1, "One");
        coll.put(2, "two");
        coll.put(3, "tree");
        coll.put(4, "four");
        coll.put(5, "five");
        coll.put(6, "six");

        for (var item: coll.entrySet()) {
            System.out.print(item.getValue() + " ");
        }

        System.out.println("\n----");

        coll.replaceAll((k, v) -> v + "!");

        for (var item: coll.entrySet()) {
            System.out.print(item.getValue() + " ");
        }

        System.out.println("\n----");

        Map<Integer, String> coll1 = new HashMap<>();
        coll1.put(0, "ноль");
        coll1.put(2, "два");
        coll1.put(9, "девять");
        coll1.put(4, "четыре");
        coll1.put(7, "семь");
        coll1.put(6, "шесть");

        for (var item: coll1.entrySet()) {
            if (coll.containsKey(item.getKey())) {
                coll.put(item.getKey(), coll.get(item.getKey()) + item.getValue());
            }
        }

        for (var item: coll.entrySet()) {
            System.out.print(item.getValue() + " ");
        }

    }
}
