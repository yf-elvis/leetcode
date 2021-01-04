package com.hyf.leetcode.dp;

import java.util.Arrays;

/**
 * @Author huyufei on 2021/1/4
 * @Desc: TODO
 */
public class MaxSubArrayII {
    public int maxSubArray(int[] nums) {
//        设dp[i]是以i结尾时子数组和的最大值
//        dp[i]= dp[i-1]+nums[i],因为可能dp[i-1]+nums[i]<nums[i]
//        所以dp[i] = max(dp[i-1]+nums[i],nums[i])
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new MaxSubArrayII().maxSubArray(new int[]{-1,-2});
        System.out.println(i);
    }
}
