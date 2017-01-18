package com.trial.baselook;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * A number is called lucky if the sum of its digits, as well as the sum of the squares of its digits is a prime number.
 * How many numbers between A and B(both inclusive) are lucky
 *
 * Created by adityaprasann on 14/1/17.
 */
public class LuckyNumbers {

    public static void main(String[] args) {
        int a = 0, b = 1000;
        LuckyNumbers luckyNums = new LuckyNumbers();
        ArrayList<Integer> luckyList = luckyNums.findLuckyNums(a, b);
        System.out.println(luckyList);
    }

    private ArrayList<Integer> findLuckyNums(int a, int b) {
        ArrayList<Integer> luckyList = new ArrayList<Integer>();
        int size = ("" + b).length();
        int maxNum = 81 * 4; //9*2*b.length() - 9 is used, coz it's the max digit
        System.out.println("Size : " + size + " MaxNum : " + maxNum);
        boolean[] primeArray = sieve(maxNum);

        for(int i = a; i <= b; i++) {
            String num = "" + i;
            int sumDigits = 0;
            int sumSquareDigits = 0;

            for(int j=0;j<num.length();j++) {
                int digit = Integer.valueOf("" + num.charAt(j));
                sumDigits += digit;
                sumSquareDigits += Math.pow(digit, 2);
            }

            if(primeArray[sumDigits] && primeArray[sumSquareDigits]) {
                luckyList.add(i);
            }
        }

        return luckyList;
    }

    private boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        int m = (int) Math.sqrt(n);

        for (int i = 2; i <= m; i++) {
            if (prime[i]) {
                for (int k = i * i; k <= n; k += i) {
                    prime[k] = false;
                }
            }
        }

        return prime;
    }
}
