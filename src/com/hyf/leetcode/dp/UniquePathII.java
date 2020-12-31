package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2020/12/31
 * @Desc: TODO
 */
public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = 1;
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                for (int k = i; k < row; k++) {
                    dp[k][0] = 0;
                }
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < column; j++) {
            if (obstacleGrid[0][j] == 1) {
                for (int k = j; k < column; k++) {
                    dp[0][k] = 0;
                }
                break;
            } else {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[row - 1][column - 1];
    }

    public static void main(String[] args) {
        int i = new UniquePathII().uniquePathsWithObstacles(new int[][]{{0, 1}, {0,0}});
        System.out.println(i);
    }
}
