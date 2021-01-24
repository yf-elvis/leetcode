package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2021/1/12
 * @Desc: TODO
 */
public class StoneGameII {
    public int stoneGameII(int[] piles) {
//        设dp[i][j]为区间[i...j]内当M取m时，当前玩家能获取到最大石子数量
        int len = piles.length;
        int sum = 0;
        int[][] dp = new int[len][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int m = 1; m <= len; m++) {
                if (i + 2 * m >= len) {
                    dp[i][m] = sum;
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        dp[i][m] = Math.max(dp[i][m], (sum - dp[i + x][Math.max(x, m)]));
                    }
                }
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        int i = new StoneGameII().stoneGameII(new int[]{2, 7, 9, 4, 4});
        System.out.println(i);
    }
}
