package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2021/1/7
 * @Desc: 统计回文串
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
//        设dp[i][j] 表示区间[i..j]内的字符串是回文
//        dp[i][j] =  Si==Sj && (j-i<2||dp[i+1][j-1])
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int aaa = new PalindromicSubstrings().countSubstrings("fdsklf");
        System.out.println(aaa);
    }
}
