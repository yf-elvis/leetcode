package com.hyf.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author huyufei on 2020/12/31
 * @Desc: 三角形最小路径和
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
//        设状态：dp[i][j]为坐标i,j点的最小路径和，则dp[i][j] = min(dp[i-1][j], dp[i-1][j-1])+triangle[i][j]
//        边界条件j<triangle[i-1].length
//        初始条件 dp[0][0] =  triangle[0][0],dp[i][0] = triangle[i][0]
        int row = triangle.size();
        int[][] dp = new int[row][1];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < row; i++) {
            dp[i] = new int[triangle.get(i).size()];
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }
        for (int i = 1; i < row; i++) {
            int column = triangle.get(i).size();
            for (int j = 1; j < column; j++) {
                dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                if (j < triangle.get(i - 1).size()) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + triangle.get(i).get(j));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < dp[row - 1].length; j++) {
            ans = Math.min(dp[row - 1][j], ans);
        }

        for(int i = 0;i<row;i++){
            int column = dp[i].length;
            for(int j = 0;j<column;j++){
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> row1 = Arrays.asList(2);
        List<Integer> row2 = Arrays.asList(3, 4);
        List<Integer> row3 = Arrays.asList(6, 5, 7);
        List<Integer> row4 = Arrays.asList(4, 1, 8, 3);
        List<List<Integer>> tri = new ArrayList<>();
        tri.add(row1);
        tri.add(row2);
        tri.add(row3);
        tri.add(row4);
        int i = new Triangle().minimumTotal(tri);
        System.out.println(i);
    }
}
