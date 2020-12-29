package com.hyf.leetcode.dp;

import java.util.Arrays;

/**
 * @Author huyufei on 2020/12/28
 * @Desc: TODO
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return Arrays.stream(dp).max().orElse(0);
    }

    public static void main(String[] args) {
        int i = new MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }
}
