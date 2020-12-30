package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2020/12/30
 * @Desc: TODO
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
//        设状态,dp[i][j]为到最后一个格子的路径和最小，如果要求dp[i][j]则要知道dp[i-1][j]和dp[i][j-1]哪个最小
//        状态转移方程:dp[i][j] = min(dp[i-1][j],dp[i][j-1])
//        对于任意一个dp[i][j]都可以从状态min(dp[i-1][j],dp[i][j-1])转移过来
        if (grid.length == 0) {
            return 0;
        }
        int length = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[length][column];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < column; j++) {
            dp[0][j] = dp[0][j - 1] + grid[j][0];
        }

        for (int i = 1; i < length; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[length - 1][column - 1];

    }

    public static void main(String[] args) {

    }
}
