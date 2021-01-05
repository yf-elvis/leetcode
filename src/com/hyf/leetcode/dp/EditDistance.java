package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2021/1/5
 * @Desc: TODO
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
//        设dp[i][j]为Word1前i个字符到workd2前j个字符转换的最小操作数
//        如果word[i]==word[j]则dp[i][j] = dp[i-1][j-1]
//        如果word[i]!=word[j]则dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
//        特别的当A为空串的时候转为B，那么需要的操作步骤数B的长度
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        int i = new EditDistance().minDistance("horse", "ros");

        System.out.println(i);
    }
}
