package com.skylite.test.Recursion;

import java.util.Arrays;
import java.util.Random;

public class Demo {

    public static void main(String[] args) {
        System.out.println(RecursionUnit.factorial(6));
        System.out.println(RecursionUnit.arraySum(RecursionUnit.generateArray(10), 0) + ", but must be 15");
        int[] testArray = new int[]{1, 2, 4, 5, 6, 7, 8, 9};
        System.out.println("Index of 9: " + RecursionUnit.binSearch(testArray, 9, 0, testArray.length - 1));
        int[] array = RecursionUnit.generateArray(100000);
        RecursionUnit.quickSearch(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

}

class RecursionUnit {

    public static int factorial(int i) {
        if (i == 1) {
            return 1;
        } else {
            return i * factorial(i - 1);
        }
    }

    public static int arraySum(int[] array, int startIndex) {
        if (array.length - startIndex == 0) {
            return 0;
        } else {
            return array[startIndex++] + arraySum(array, startIndex);
        }
    }

    public static int binSearch(int[] sortArray, int needValue, int from, int to) {

        int offset = from + ((to - from) / 2);

        if (to == from && sortArray[offset] != needValue) {
            return -1;
        }

        if (sortArray[offset] == needValue) {
            return offset;
        }
        if (sortArray[offset] < needValue) {
            return binSearch(sortArray, needValue, offset + 1, to);
        }
        if (sortArray[offset] > needValue) {
            return binSearch(sortArray, needValue, from, offset - 1);
        }
        return 777;
    }

    public static void quickSearch(int[] array, int from, int to) {

        if (to == from) {
            return;
        }

        int mainStayIndex = from;

        int tmp;

        for (int i = from + 1; i <= to; i++) {
            if (array[mainStayIndex] > array[i]) {
                tmp = array[i];
                System.arraycopy(array, mainStayIndex, array, mainStayIndex + 1, i - mainStayIndex);
                array[mainStayIndex++] = tmp;
            }
        }

        if (mainStayIndex != from) {
            quickSearch(array, from, mainStayIndex - 1);
        }
        if (mainStayIndex != to) {
            quickSearch(array, mainStayIndex + 1, to);
        }

    }

    public static int[] generateArray(int length) {
        int[] result = new int[length];
        Random random = new Random();
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt() % 1000;
        }
        return result;
    }
}