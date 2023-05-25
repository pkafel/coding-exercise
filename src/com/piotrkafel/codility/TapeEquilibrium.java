package com.piotrkafel.codility;

/**
 * Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
 */
public class TapeEquilibrium {

    public static int solution(int[] A) {
        int[] sums = new int[A.length];

        sums[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sums[i] = sums[i - 1] + A[i];
        }

        int result = 1;
        for (int i = 1; i < sums.length; i++) {
            int leftNewSum = sums[i - 1];
            int rightNumSum = sums[sums.length - 1] - sums[i - 1];
            int leftOldSum = sums[result - 1];
            int rightOldSum = sums[sums.length - 1] - sums[result - 1];

            if (Math.abs(leftNewSum - rightNumSum) < Math.abs(leftOldSum - rightOldSum)) {
                result = i;
            }
        }

        return Math.abs(2 * sums[result - 1] - sums[sums.length - 1]);
    }
}
