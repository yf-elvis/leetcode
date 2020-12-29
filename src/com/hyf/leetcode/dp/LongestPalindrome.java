package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2020/12/29
 * @Desc: 最长回文子串
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
//       如果串的长度为1则它是回文串
//        如果串的长度为2则判断s[i]和s[i+1]是否相等
//        如果串的长度大于2则判断dp[i-1][j+1]是否相等还要判断i<=j
//       设状态dp[i][j]表示表示s[i]到s[j]的字符串是回文串
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        String ans = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j + i < length; j++) {
//                步长
                int k = j + i;
                if (i == 0) {
                    dp[j][k] = true;
                } else if (i == 1 && s.charAt(j) == s.charAt(k)) {
                    dp[j][k] = true;
                } else {
                    if (dp[j + 1][k - 1] && s.charAt(j) == s.charAt(k)) {
                        dp[j][k] = true;
                    }
                }
                if (dp[j][k] && i + 1 > ans.length()) {
                    ans = s.substring(j, j + i + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String dabad = new LongestPalindrome().longestPalindrome("caba");
        System.out.println(dabad);
    }
}
