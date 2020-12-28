package com.hyf.leetcode.array;

/**
 * @Author huyufei on 2020/11/19
 * @Desc: 转置矩阵
 */
public class Transpose {

    public int[][] transpose(int[][] A) {
        int[][] res = new int[A[0].length][];
        for (int i = 0; i < A[0].length; i++) {
            res[i] = new int[A.length];
            for (int j = 0; j < A.length; j++) {
                res[i][j] = A[j][i];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int t[][] = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        int[][] transpose = new Transpose().transpose(t);
        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[0].length; j++) {
                System.out.printf("%d ", transpose[i][j]);
            }
            System.out.println();
        }
    }
}
