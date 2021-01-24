package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2021/1/10
 * @Desc: TODO
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;

//        设dp1[i][j]代表i，j做坐标长度最大值
//        dp2[i][j]代表i,j坐标宽度最大值
        int[][] dp1 = new int[row][column];
        int[][] dp2 = new int[row][column];
        dp1[0][0] = matrix[0][0] == '1' ? 1 : 0;
        dp2[0][0] = matrix[0][0] == '1' ? 1 : 0;
        int max1 = dp1[0][0];
        int max2 = dp2[0][0];
        for (int j = 0; j < column; j++) {
            dp1[0][j] = matrix[0][j] == '1' ? 1 : 0;
            dp2[0][j] = matrix[0][j] == '1' ? 1 : 0;
            max1 = Math.max(dp1[0][j], max1);
            max2 = Math.max(dp2[0][j], max2);
        }
        for (int i = 0; i < row; i++) {
            dp1[i][0] = matrix[i][0] == '1' ? 1 : 0;
            dp2[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max1 = Math.max(dp1[i][0], max1);
            max2 = Math.max(dp2[i][0], max2);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == '0') {
                    dp1[i][j] = 0;
                    dp2[i][j] = 0;
                } else {

                    if (dp1[i - 1][j] == 0 || dp1[i - 1][j - 1] == 0 || dp1[i][j - 1] == 0) {
                        dp1[i][j] = Math.min(dp1[i - 1][j], Math.min(dp1[i - 1][j - 1], dp1[i][j - 1])) + 1;
                    } else {
                        dp1[i][j] = dp1[i][j - 1] + 1;
                    }
                    max1 = Math.max(dp1[i][j], max1);

                    if (dp2[i - 1][j] == 0 || dp2[i - 1][j - 1] == 0 || dp2[i][j - 1] == 0) {
                        dp2[i][j] = Math.min(dp2[i - 1][j], Math.min(dp2[i - 1][j - 1], dp2[i][j - 1])) + 1;
                    } else {
                        dp2[i][j] = dp2[i - 1][j] + 1;
                    }
                    max2 = Math.max(dp2[i][j], max2);

                }
            }
        }
        return max1*max2;
    }

    public static void main(String[] args) {
        int i = new MaximalRectangle().maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});
        System.out.println(i);

    }
}
