package com.piotrkafel.leetcode;

import java.util.Arrays;

public class ClimbingStairs {

    // Purely recursive approach
    public int climbStairsRecursive(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public int climbStairs(int n) {
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);
        return climbStairs(n, cache);
    }

    public int climbStairs(int n, int[] cache) {
        if(cache[n] != -1) return cache[n];
        if(n == 1) {
            cache[n] = 1;
            return 1;
        }
        if(n == 2) {
            cache[n] = 2;
            return 2;
        }
        int result = climbStairs(n-1, cache) + climbStairs(n-2, cache);
        cache[n] = result;
        return result;
    }
}
