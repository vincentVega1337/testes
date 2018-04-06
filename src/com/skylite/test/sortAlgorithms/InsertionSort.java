package com.skylite.test.sortAlgorithms;

public class InsertionSort {
    public static void Sort(int[] container) {
        int tmp;
        for (int i = 0; i < container.length; i++) {
            for (int j = 0; j < i; j++) {
                if (container[i] < container[j]) {
                    tmp = container[i];
                    System.arraycopy(container, j, container, j + 1, i - j);
                    container[j] = tmp;
                    }
            }
        }
    }
}
