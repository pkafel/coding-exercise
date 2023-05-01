package com.piotrkafel.lesson1;

/**
 * Find the missing element in a given permutation.
 */
public class PermMissingElem {

    public static int solution(int[] A) {
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        int highestElement = A.length + 1;
        return (int)(((highestElement + Math.pow(highestElement, 2))/2) - sum);
    }
}
