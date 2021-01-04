package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2021/1/4
 * @Desc: TODO
 */
public class IntegerBreak {

    public int integerBreak(int n) {
//        设dp[i]为正整数i至少拆分成两个正整数后各个正整数乘积的最大值
//        如果第一次拆分的正整数是j，那么正整数i-j可以继续选择拆分或者不拆
//        如果不拆dp[i] = j*(i-j)  1<=j<i
//        如果继续拆分则dp[i] = j*dp[i-j]
//        dp[i] = max(j*(i-j),j*dp[i-j])
//        特别的当n==0或者n==1时候，dp[0]=dp[1] = 0
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = new IntegerBreak().integerBreak(10);
        System.out.println(i);
    }
}
