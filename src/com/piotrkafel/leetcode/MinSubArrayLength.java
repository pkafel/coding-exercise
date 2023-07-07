package com.piotrkafel.leetcode;

public class MinSubArrayLength {

    // https://leetcode.com/problems/minimum-size-subarray-sum/
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0, l = 0, result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= target) {
                int currentLength = i - l + 1;
                result = Math.min(result, currentLength);
                sum -= nums[l++];
            }
        }
        if(result == Integer.MAX_VALUE) return 0;
        else return result;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1}));
    }
}
