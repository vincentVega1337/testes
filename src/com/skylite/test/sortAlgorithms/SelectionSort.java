package com.skylite.test.sortAlgorithms;

public class SelectionSort {

    public static void Sort(int container[]) {
        int tmp;
        for (int i = 0; i < container.length; i++) {
            for (int j = 0; j < container.length; j++) {
                if (container[j] > container[i]) {
                    tmp = container[i];
                    container[i] = container[j];
                    container[j] = tmp;
                }
            }
        }
    }
}
