package org.example;

import java.util.Random;

public class Seminar1 {

    public static void main(String[] args) {
        
        int i = new Random().nextInt(2000);
        int n = Integer.toBinaryString(i).length() - 1;

        short m1_len = 0;
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j % n == 0) {
               m1_len++;
            }
        }

        int[] m1 = new int[m1_len];
        short count = 0;
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j % n == 0) {
                m1[count] = j;
                count++;
            }
        }

        short m2_len = 0;
        for (int j = i; j > Short.MIN_VALUE; j--) {
            if (j % n != 0) {
                m2_len++;
            }
        }

        int[] m2 = new int[m2_len];
        short count_2 = 0;
        for (int j = i; j > Short.MIN_VALUE; j--) {
            if (j % n != 0) {
                m2[count_2] = j;
                count_2++;
            }
        }


    }
}
