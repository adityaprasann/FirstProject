package com.sampleds;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class MergeSortApp {

    private final static int LEN = 50;
    private static int[] arrToSort = new int[LEN];
    private static int[] temp = new int[LEN];

    public static void main(String[] args) {
        Random random = new Random();
        MergeSortApp mergeSortApp = new MergeSortApp();
        IntStream.range(0,LEN-1).forEach(idx -> arrToSort[idx] = random.nextInt(1000) - 500);
        System.out.println("Before Merge Sort");
        Arrays.stream(arrToSort).forEach(ele -> System.out.print(ele + " "));

        mergeSortApp.mergeSort(0, LEN - 1);

        System.out.println();
        System.out.println("After Merge Sort");
        Arrays.stream(arrToSort).forEach(ele -> System.out.print(ele + " "));
    }

    private void mergeSort(int left, int right) {
        if (left >= right)//terminal condition
            return;
        int middle = (left + right) / 2;
        mergeSort(left, middle);
        mergeSort(middle + 1, right);
        merge(left, middle, right);//collapse
    }

    private void merge(int left, int middle, int right) {
        //copy of original array
        for(int idx=left; idx <= right; idx++)
            temp[idx] = arrToSort[idx];
        int i = left;
        int j = middle + 1;
        int k = left;
        while((i <= middle) && (j <= right)) {
            if (temp[i] < temp[j]) {
                arrToSort[k] = temp[i];
                i++;
            } else {
                arrToSort[k] = temp[j];
                j++;
            }
            k++;
        }
        //copy remaining elements from 1st area
        while(i <= middle) {
            arrToSort[k] = temp[i];
            i++;
            k++;
        }
        //copy remaining elements from 2nd area
        while(j <= right) {
            arrToSort[k] = temp[j];
            j++;
            k++;
        }
    }
}
