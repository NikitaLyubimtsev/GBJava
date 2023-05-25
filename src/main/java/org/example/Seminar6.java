package org.example;

import java.util.*;
import java.util.stream.IntStream;

public class Seminar6 {
    public static void main(String[] args) {

        mySet mySet = new mySet();
        IntStream.range(0, 15).map(i -> new Random().nextInt(100)).forEach(mySet::add);
        System.out.println(mySet.contains(2));
        System.out.println(Arrays.toString(mySet.toArray()));

        Iterator<Integer> iterator = mySet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println(mySet.get(2));

        myTreeSet tree = new myTreeSet(Comparator.naturalOrder());
        IntStream.range(0, 15).map(i -> new Random().nextInt(100)).forEach(tree::add);
        Iterator iterator1 = tree.iterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + ", ");
        }
    }
}

class mySet {
    private LinkedHashMap<Integer, Object> map = new LinkedHashMap<>();
    static final Object OBJ = new Object();

    public boolean add(int num) {
        return map.put(num, OBJ) == null;
    }

    public boolean contains(int num) {
        return map.containsKey(num);
    }

    public String toString() {
        return Arrays.toString(toArray());
    }

    public Object[] toArray() {
        return map.keySet().toArray();
    }

    public Iterator<Integer> iterator() {
        return map.keySet().iterator();
    }

    public int get(int idx) {
        return (Integer) toArray()[idx];
    }
}

class myTreeSet {
    private Comparator<Integer> comparator;
    public myTreeSet(Comparator<Integer> comp) {
        comparator = comp;
    }
    private TreeMap<Integer, Object> map = new TreeMap<>(comparator);
    static final Object OBJ = new Object();

    public boolean add(int num) {
        return map.put(num, OBJ) == null;
    }

    public boolean contains(int num) {
        return map.containsKey(num);
    }

    public String toString() {
        return  Arrays.toString(toArray());
    }

    public Object[] toArray() {
        return map.keySet().toArray();
    }

    public Iterator<Integer> iterator() {
        return map.keySet().iterator();
    }

    public int get(int idx) {
        return (Integer) toArray()[idx];
    }
}
