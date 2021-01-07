package com.hyf.leetcode.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author huyufei on 2021/1/6
 * @Desc: TODO
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
//        设dp[i]表示前i个字符串能拆分成出现在dict中的单次
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        boolean b = new WordBreak().wordBreak("catsanddog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        String substring = "aab".substring(2, 3);
        System.out.println(substring);
        System.out.println(b);
    }
}
