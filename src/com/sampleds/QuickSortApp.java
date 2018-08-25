package com.sampleds;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class QuickSortApp {

    private final static int LEN = 50;
    private static int[] arrToSort = new int[LEN];

    public static void main(String[] args) {
        Random random = new Random();
        IntStream.range(0,LEN-1).forEach(idx -> arrToSort[idx] = random.nextInt(1000) - 500);
        System.out.println("Before Quick Sort");
        Arrays.stream(arrToSort).forEach(ele -> System.out.print(ele + " "));

        QuickSortApp quickSortApp = new QuickSortApp();
        quickSortApp.quickSort(0, LEN-1);

        System.out.println();
        System.out.println("After Quick Sort");
        Arrays.stream(arrToSort).forEach(ele -> System.out.print(ele + " "));
    }

    private void quickSort(int start, int last) {
        if(start < last){
            int nextPivot = partition(start, last);
            quickSort(start,nextPivot-1);
            quickSort(nextPivot+1, last);
        }
    }

    /*
     @return index of next pivot on which partition has to happen.
     After this method return the element at pivot is at its final sorted position.
     */
    private int partition(int p, int r) {
        int nextPivot = p-1;//start 1 index before start
        for (int j = p; j <= r-1; j++){
            if(arrToSort[j] <= arrToSort[r]){
                //run from 1st element to last but 1 as last element is the element which will be gauranteed to be at correct position
                nextPivot = nextPivot + 1;
                swapElement(nextPivot, j);//swap current element to whatever is next pivot candidate
            }
        }
        nextPivot = nextPivot + 1;
        swapElement(nextPivot,r);//swap last element to its correct position
        return nextPivot;
    }

    private void swapElement(int first, int second) {
        int temp = arrToSort[second];
        arrToSort[second] = arrToSort[first];
        arrToSort[first] = temp;
    }
}
