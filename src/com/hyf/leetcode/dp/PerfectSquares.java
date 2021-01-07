package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2021/1/7
 * @Desc: TODO
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (advancedIsSquare(i)) {
                dp[i] = 1;
                continue;
            }
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                int k = i - j;
                dp[i] = Math.min(dp[i], dp[k] + dp[j]);
            }
        }
        return dp[n];
    }

    public boolean advancedIsSquare(int num) {
        double a = 0;
        try {
            a = Math.sqrt(num);
        } catch (Exception e) {
            return false;
        }
        int b = (int) a;
        return a - b == 0;

    }


    public static void main(String[] args) {
        int i = new PerfectSquares().numSquares(13);
        System.out.println(i);
    }
}
