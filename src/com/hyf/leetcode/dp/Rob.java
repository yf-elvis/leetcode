package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2020/12/30
 * @Desc: 打家劫舍
 */
public class Rob {

    public int rob(int[] nums) {
//        对于第K间房屋，有两种可能
//        1. 偷第K间，则第k-1间房屋不能偷，最高金额为dp[i-2] + nums[i]
//        2. 不偷第第k间房屋，则最高金额在dp[i-1]
//        取两者的最大值
//        边界情况，两间房屋只能偷一间，只能偷最高的那间
//        设dp[i]为第i间房屋能偷窃到的总金额
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
        int rob = new Rob().rob(new int[]{2, 7, 9, 3, 1});
        System.out.println(rob);
    }
}
