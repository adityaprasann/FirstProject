package com.trial.baselook;

import java.util.stream.IntStream;

/**
 * Created by adityaprasann on 17/12/16.
 */
public class FirstTrial {

    static Object lock = new Object();

    static int[] elementsArray;
    static int count;

    static class Producer{
        public void produce(){
            synchronized (lock) {
                if (isFull(elementsArray))
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                elementsArray[count ++] = 1;
                lock.notify();
            }
        }

    }



    static class Consumer{
        public void consume(){
            synchronized (lock) {
                if (isEmpty(elementsArray))
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                elementsArray[--count] = 0;
                lock.notify();
            }
        }

    }

    private static boolean isFull(int[] elementsArray) {
        return elementsArray.length == count;
    }

    private static boolean isEmpty(int[] elementsArray) {
       return count == 0;
    }

    public static void main(String... args) throws InterruptedException {

        elementsArray = new int[1];
        count = 0;

        Thread producerThread = new Thread(() -> IntStream.range(1,50).forEach(idx -> new Producer().produce()));
        Thread consumerThread = new Thread(() -> IntStream.range(1,50).forEach(idx -> new Consumer().consume()));

        producerThread.start();
        consumerThread.start();

        consumerThread.join();
        producerThread.join();

        System.out.println("The data is " + count);

    }

}
