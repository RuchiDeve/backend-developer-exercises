package org.example;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static int findSmallestNonOccurringInteger(int[] array) {
        Set<Integer> set = new HashSet<>();
        int max = 0;

        for (int num : array) {
            if (num > 0) {
                set.add(num);
                if (num > max) {
                    max = num;
                }
            }
        }

        for (int i = 1; i <= max + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 6, 4, 1, 2};
        int[] array2 = {5, -1, -3};

        System.out.println("Smallest non-occurring integer in Array1: " + findSmallestNonOccurringInteger(array1));
        System.out.println("Smallest non-occurring integer in Array2: " + findSmallestNonOccurringInteger(array2));
    }
}
