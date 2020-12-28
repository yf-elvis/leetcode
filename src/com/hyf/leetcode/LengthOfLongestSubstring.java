package com.hyf.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author huyufei on 2020/10/25
 * @Desc: 寻找最长不含有重复字符的子串
 */
public class LengthOfLongestSubstring {

    //    set [w]
    //    pwwwkew
    // i, j
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Set<Character> occurred = new HashSet<>();
        for (int i = 0, j = 0; i < s.length() && j < s.length(); ) {
            if (!occurred.contains(s.charAt(j))) {
                occurred.add(s.charAt(j++));
                maxLen = Math.max(maxLen, j - i);
            } else {
                occurred.remove(s.charAt(i++));
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int pwwkew = new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb");
        System.out.println(pwwkew);
    }
}
