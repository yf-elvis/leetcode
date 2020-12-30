package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2020/12/30
 * @Desc: 爬楼梯
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
//        设dp[n]爬到第n台阶所需要的方法数dp[n] =  dp[n-2] + dp[n-1]
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        //        初始条件当只有一个台阶的时候方法数为1
        dp[1] = 1;
//        当为两个台阶的时候，可以一步跨两个，也可以一步一个，方法数为2
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = new ClimbingStairs().climbStairs(10);
        System.out.println(i);
    }
}
