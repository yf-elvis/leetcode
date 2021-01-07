package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2021/1/7
 * @Desc: TODO
 */
public class MaxSquare {

    public int maximalSquare(char[][] matrix) {

        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
//        初始化
        int max = matrix[0][0] == '1' ? 1 : 0;
        for (int j = 0; j < column; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
            max = Math.max(max, dp[0][j]);
        }
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
            max = Math.max(max, dp[i][0]);
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        int i = new MaxSquare().maximalSquare(new char[][]{{'0'},{'1'}});
//        int i = new MaxSquare().maximalSquare(new char[][]{{'1', '0', '1', '0', '0' }, {'1', '0', '1', '1', '1' }, {'1', '1', '1', '1', '1' }, {'1', '0', '0', '1', '0' }});
        System.out.println(i);
    }
}
