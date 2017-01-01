package com.trial.baselook;

/**
 * Created by adityaprasann on 25/12/16.
 *
 * Codility test noon.com
 *
 * Maximum sequence of coin after one flip
 */
public class CoinAdj {

    public static void main(String... args) {
        int[] A = {1, 1, 0, 1, 0, 0};
        int n = A.length;
        int result = 0;
        int maxResult = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1])
                result = result + 1;
            else {
                if (maxResult == 0 || maxResult < result) {
                    maxResult = result;
                    result = 0;
                }
            }
        }

        System.out.println("result " + result);
        System.out.println("maxResult " + maxResult);

        int r = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (i > 0) {
                if (i < n - 1) {
                    if ((A[i + 1] != A[i]) && (A[i - 1] != A[i]))
                        count = count + 2;
                    else if ((A[i + 1] != A[i]) || (A[i - 1] != A[i]))
                        count = count + 1;
                    else
                        count = count - 1;
                }
            }
            else {
                if (i < n - 1) {
                    if (A[i + 1] != A[i])
                        count = count + 1;
                    else
                        count = count - 1;
                }
            }
            r = Math.max(r, count);
        }
        System.out.println(maxResult + r);
    }

}
