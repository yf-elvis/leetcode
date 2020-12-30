package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2020/12/30
 * @Desc: TODO
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
//        计数型动态规划
//       设dp[n]表示跳到第n个台阶所花需的最小体力值，则dp[n] = min(dp[n-1] + dp[n-2]) + cost[n]
        if (cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public static void main(String[] args) {
        int i = new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println(i);
    }
}
