package com.sampleds;

import java.util.Arrays;

public class BHeap {

    private final int[] heap;
    private int heapsize;

    private BHeap(int capacity) {
        this.heap = new int[capacity];
        Arrays.fill(this.heap, -1);
        this.heap[0] = 0;
        this.heapsize = 1;
    }

    private void insert(int element){
        this.heap[this.heapsize] = element;
        this.heapsize++;
        perUp();
    }

    private void perUp() {
        int insertPos = this.heapsize - 1;
        while (insertPos/2 > 0){
            int curr = this.heap[insertPos];
            int par = this.heap[insertPos/2];
            if(curr < par){
                swap(insertPos,insertPos/2);
            }
            insertPos = insertPos/2;
        }
    }

    private void swap(int insertPos, int parentPos) {
        int temp = this.heap[parentPos];
        this.heap[parentPos] = this.heap[insertPos];
        this.heap[insertPos] = temp;
    }

    private int delMin() {
        int retVal = this.heap[1];
        this.heapsize--;
        this.heap[1] = this.heap[this.heapsize];
        this.heap[this.heapsize] = -1;
        perDown();
        return retVal;
    }

    private void perDown() {
        int idx = 1;
        while (idx * 2 <= this.heapsize){
            int curr = this.heap[idx];
            int ch = this.heap[idx*2];
            if (curr > ch)
               swap(idx, idx*2);
            idx = idx * 2;
        }
    }

    public static void main(String[] args) {
        BHeap bh = new BHeap(15);
        bh.insert(18);
        bh.insert(19);
        bh.insert(21);
        bh.insert(17);
        bh.insert(27);
        bh.insert(33);
        bh.insert(11);
        bh.insert(14);
        bh.insert(9);
        bh.insert(5);
        System.out.println(Arrays.toString(bh.heap).substring(1,Arrays.toString(bh.heap).indexOf("-1") - 2));

        System.out.println(bh.delMin());

        System.out.println(Arrays.toString(bh.heap).substring(1,Arrays.toString(bh.heap).indexOf("-1") - 2));
    }



}
