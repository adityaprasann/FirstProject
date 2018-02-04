package com.trial.baselook;

import java.util.*;
import java.util.function.Function;

public class BucketizeSort {


    private static final Function<Integer, Integer> bucketize = i -> i % 3;


    private void sort(int[] a) {
        List<Integer> sorted = new ArrayList<>();
        for (int i : a)
        {
            sorted.add(i);
        }
        sorted.sort(Comparator.comparing(BucketizeSort.bucketize));
        System.out.println(sorted);
    }

    public static void main(String[] args) {
        int[] a = {5,3,4,1,2};
        BucketizeSort b = new BucketizeSort();
        b.sort(a);

    }
}
