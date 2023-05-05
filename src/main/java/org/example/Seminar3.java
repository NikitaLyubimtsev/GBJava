package org.example;


import java.util.*;


class CustomComparator<T extends Comparable<T>> implements Comparator<T>
{
    @Override
    public int compare(T a, T b) {
        return b.compareTo(a);
    }
}
public class Seminar3 {

    public static List<Integer> removeOddNumbers(List<Integer> list) {
        list.removeIf(i -> i % 2 != 0);
        return list;
    }
    public static void main(String[] args) {

        // Сортировка списка в обратном проядке компоратором
        List<Integer> nums = Arrays.asList(10, 6, 7, 12, 23, 45, 678, 12, 34);
        nums.sort(new CustomComparator<>());

        System.out.println(nums);

        // Удаление из списка чётных чисел
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        System.out.println(removeOddNumbers(nums2));

        // Найти минимальное, максимальное и среднее значение из списка
        int myArray[] = {10, 6, 7, 12, 23, 45, 678, 12, 34};
        System.out.println(Arrays.stream(myArray).sum());
    }
}
