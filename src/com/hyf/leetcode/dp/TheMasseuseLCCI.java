package com.hyf.leetcode.dp;

import java.util.Arrays;

/**
 * @Author huyufei on 2021/1/3
 * @Desc: 按摩师
 */
public class TheMasseuseLCCI {

    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return Arrays.stream(dp).max().orElse(0);
    }

    public static void main(String[] args) {
        int massage = new TheMasseuseLCCI().massage(new int[]{1,2,3,1});
        System.out.println(massage);
    }
}
