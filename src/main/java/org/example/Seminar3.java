package org.example;


import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class CustomComparator<T extends Comparable<T>> implements Comparator<T>
{
    @Override
    public int compare(T a, T b) {
        return b.compareTo(a);
    }
}
public class Seminar3 {

    public static ArrayList<Integer> removeOddNumbers(ArrayList<Integer> list) {
        list.removeIf(i -> i % 2 != 0);
        return list;
    }

    public static void main(String[] args) {

        // Сортировка списка в обратном проядке компоратором
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(10, 6, 7, 12, 23, 45, 678, 12, 34));
        nums.sort(new CustomComparator<>());

        System.out.println(nums);

        // Удаление из списка чётных чисел
        ArrayList<Integer> myArr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 45));
        ArrayList<Integer> res2 = removeOddNumbers(myArr);
        System.out.println(res2);

        // Найти минимальное, максимальное и среднее значение из списка
        ArrayList<Integer> myArr2 = new ArrayList<>(Arrays.asList(10, 6, 7, 12, 23, 45, 678, 12, 34));

        int minValue = myArr2.stream().min(Integer::compare).get();
        int maxValue = myArr2.stream().max(Integer::compare).get();
        int avgValue = myArr2.stream().reduce(0, Integer::sum) / myArr2.size();
        System.out.println(minValue);
        System.out.println(maxValue);
        System.out.println(avgValue);

        // Объеденить два списка без повторений
        myArr2.removeAll(myArr);
        myArr.addAll(myArr2);
        System.out.println(myArr);

        // Добавить 1000 раз 0 объект массива
        ArrayList<Integer> res1K = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            res1K.add(myArr.get(0));
        }
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("ArrayList " + time);
        System.out.println(res1K);

        // Сравнить с работой linkedList

        LinkedList<Integer> numbers = new LinkedList<>();
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            numbers.add(myArr.get(0));
        }
        end = System.nanoTime();
        time = end - start;
        System.out.println("LinkedList " + time);
        System.out.println(numbers);
    }
}
