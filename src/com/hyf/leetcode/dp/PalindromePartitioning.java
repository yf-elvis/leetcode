package com.hyf.leetcode.dp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author huyufei on 2021/1/6
 * @Desc: 分割回文串
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> ans = new ArrayList<>();
        if (len == 0) {
            return ans;
        }

        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
        // 注意：只使用 stack 相关的接口
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, stack, ans);
        return ans;
    }

    public void backtracking(String s, int start, int len, Deque<String> stack, List<List<String>> ans) {
        if (start == len) {
            List<String> list = new ArrayList<>(stack);
            ans.add(list);
            return;
        }

        for (int i = start; i < len; i++) {

            if (!isPalindome(s, start, i)) {
                continue;
            }

            stack.addLast(s.substring(start, i + 1));
            backtracking(s, i + 1, len, stack, ans);
            stack.removeLast();
        }
    }

    public boolean isPalindome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> aab = new PalindromePartitioning().partition("aab");
        System.out.println(aab);
    }

}
