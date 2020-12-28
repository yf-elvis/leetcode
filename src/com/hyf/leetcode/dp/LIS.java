package com.hyf.leetcode.dp;

import java.util.Arrays;

/**
 * @Author huyufei on 2020/12/28
 * @Desc: TODO
 */
public class LIS {
    public int lengthOfLIS(int[] nums) {
//        状态转移方程dp[i] = max(dp[j])+1 0<=j<i
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(1);
    }

    public static void main(String[] args) {
        int i = new LIS().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(i);
    }
}
