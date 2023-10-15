package com.piotrkafel.leetcode;

public class BestTimetoBuyAndSell {

    public int maxProfit(int[] prices) {
        int[] buyDayPrice = new int[prices.length];
        int[] sellDayPrice = new int[prices.length];

        buyDayPrice[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(buyDayPrice[i-1] < prices[i]) {
                buyDayPrice[i] = buyDayPrice[i-1];
            } else {
                buyDayPrice[i] = prices[i];
            }
        }

        sellDayPrice[sellDayPrice.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            if(sellDayPrice[i + 1] > prices[i]) {
                sellDayPrice[i] = sellDayPrice[i + 1];
            } else {
                sellDayPrice[i] = prices[i];
            }
        }

        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            if(sellDayPrice[i] - buyDayPrice[i] > result) {
                result = sellDayPrice[i] - buyDayPrice[i];
            }

        }

        return result;
    }
}
