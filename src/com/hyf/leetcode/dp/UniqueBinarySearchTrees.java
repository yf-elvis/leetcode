package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2021/1/3
 * @Desc: TODO
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
//        设dp[n]是长度为n的序列所构成的不同二叉搜索树的个数
//        dp[n] = dp[0]*dp[n-1]+ dp[1]*dp[n-2]+......dp[0]*dp[n-1]
//        初始条件dp[0] = 1,dp[1] = 1
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = new UniqueBinarySearchTrees().numTrees(10);
        System.out.println(i);
    }
}
