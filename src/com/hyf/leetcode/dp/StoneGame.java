package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2021/1/11
 * @Desc: TODO
 */
public class StoneGame {
    public boolean stoneGame(int[] piles) {
//设dp[i][j]为当前玩家在区间[i..j]所获得的的石子数量比另一个玩家多的差值
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = piles[i];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }


    public static void main(String[] args) {
        boolean b = new StoneGame().stoneGame(new int[]{3, 7, 2, 3});
        System.out.println(b);
    }
}
