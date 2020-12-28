package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2020/12/28
 * @Desc: TODO
 */
public class UniquePathI {

    public int uniquePaths(int m, int n) {
//    对于任意一点dp[i][j] = dp[i-1][j] + dp[i][j-1]
//      初始化条件
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int i = new UniquePathI().uniquePaths(3, 2);
        System.out.println(i);
    }
}
