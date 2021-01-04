package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2021/1/4
 * @Desc: TODO
 */
public class CuttingRope {

    public int cuttingRope(int n) {
//        设dp[i]以长度为i绳子至少拆成两段每段乘积的最大值
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
        int i = new CuttingRope().cuttingRope(10);
        System.out.println(i);
    }
}
