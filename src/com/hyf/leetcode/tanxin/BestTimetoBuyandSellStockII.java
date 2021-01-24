package com.hyf.leetcode.tanxin;

/**
 * @Author huyufei on 2021/1/9
 * @Desc: TODO
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new BestTimetoBuyandSellStockII().maxProfit(new int[]{7, 1, 5, 3, 4, 6});
        System.out.println(i);
    }
}
