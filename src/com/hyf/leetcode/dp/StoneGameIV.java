package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2021/1/14
 * @Desc: TODO
 */
public class StoneGameIV {
    public boolean winnerSquareGame(int n) {
//        设dp[i]表示当前玩家在面对i颗石子的时候处于必胜态dp[i]=true
//        当前他可以拿k的平方个，k的平方小于i，那么另一个玩家可以拿i-k的平方，他处于必败态 dp[i-k*k]=false
//        初态dp[0]=false
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k * k <= i; k++) {
                if (!dp[i - k * k]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        boolean b = new StoneGameIV().winnerSquareGame(7);
        System.out.println(b);
    }
}
