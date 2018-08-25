package com.sampleds;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class InsertionSortApp {

    private final static int LEN = 50;
    private static int[] arrToSort = new int[LEN];

    public static void main(String[] args) {

        Random random = new Random();
        IntStream.range(0,LEN-1).forEach(idx -> arrToSort[idx] = random.nextInt(1000) - 500);
        System.out.println("Before Insertion Sort");
        Arrays.stream(arrToSort).forEach(ele -> System.out.print(ele + " "));

        InsertionSortApp insertionSortApp = new InsertionSortApp();
        insertionSortApp.performInsertionSort();

        System.out.println();
        System.out.println("After Insertion Sort");
        Arrays.stream(arrToSort).forEach(ele -> System.out.print(ele + " "));
    }

    private void performInsertionSort() {
        int pointer = 1;
        while(pointer <= LEN -1){
            int j = pointer;
            while(j-1 >= 0 ) {
                if (arrToSort[j-1] > arrToSort[j]){
                    swapElement(j-1, j);
                }
                j--;
            }
            pointer++;
        }
    }

    private void swapElement(int first, int second) {
        int temp = arrToSort[second];
        arrToSort[second] = arrToSort[first];
        arrToSort[first] = temp;
    }
}
