package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2021/1/8
 * @Desc: TODO
 */
public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
//        设dp[i]为第i天所获得的最大利润
//        dp[i] = max(prices[i]-min,dp[i-1])
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(prices[i] - min, dp[i - 1]);
        }
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        int i = new BestTimetoBuyandSellStock().maxProfit(new int[]{7,6,4,3,1});
        System.out.println(i);
    }
}
