package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2021/1/9
 * @Desc: TODO
 */
public class DivisorGame {

    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 3];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        boolean b = new DivisorGame().divisorGame(3);
        System.out.println(b);
    }
}
