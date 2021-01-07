package com.hyf.leetcode.dp;

import java.util.Arrays;

/**
 * @Author huyufei on 2021/1/6
 * @Desc: 打家劫舍2
 */
public class RobII {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(myRob(Arrays.copyOfRange(nums, 1, nums.length)),
                myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    public int myRob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int rob = new RobII().rob(new int[]{2, 3, 2});
        System.out.println(rob);
    }
}
