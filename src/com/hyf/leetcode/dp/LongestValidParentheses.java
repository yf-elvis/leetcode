package com.hyf.leetcode.dp;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author huyufei on 2021/1/1
 * @Desc: 最长有效括号
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
//       设dp[i]表示最长有效字子字符串的长度
//        当Si=')'并且Si-1='('时候，dp[i] = dp[i-2] + 2，因为()是一个整体，dp[i-2]就代表()前面的子字符串最长的长度再加上2就是当前()的子字符串的最长
//        当Si=')'并且Si-1=')' 形如))时候，当S[i-dp[i-1]-1]='('时候说明是一个内嵌括号，那么dp[i]= 2 + dp[i-1]  + dp[i-d[i-1]-2]
//        其中dp[i-1]是内嵌子字符串的长度，+2是当前是个有小括号长度，dp[i-dp[i-1]-2]是一开始的长度
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 0;
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 0);
        if (s.charAt(0) == '(' && s.charAt(1) == ')') {
            dp[0] = 0;
            dp[1] = 2;
        }
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1];
                }
            }
        }

        return Arrays.stream(dp).max().orElse(0);
    }

    public static void main(String[] args) {
        int i = new LongestValidParentheses().longestValidParentheses("()()))(()))(()()()()()()))))((((()))))");
        System.out.println(i);
    }
}
