package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2021/1/4
 * @Desc: 乘积最大子数组
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
//        设dpmax[i]代表以下标i结尾的连续子数组乘积最大值
//        dpmin[i]代表以下标i结尾的连续子数组乘积最小值
//        因为是乘积，所以可能dp[i-1]是最大值但是乘以一个负数就成了最小值，因此还要一个数组记录连续子数组的最小值，乘以当前nums[i]
//        也就是dpmax[i] = max(dpmax[i-1]*nums[i], max(dpmin(i-1)*nums[i], nums[i]))
//        dpmin[i] = min(dpmin[i-1]*nums[i], min(dpmax[i-1]*nums[i], nums[i]))
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dpmax = new int[nums.length];
        int[] dpmin = new int[nums.length];
        dpmax[0] = nums[0];
        dpmin[0] = nums[0];
        int sns = dpmax[0];
        for (int i = 1; i < nums.length; i++) {
            dpmax[i] = Math.max(dpmax[i - 1] * nums[i], Math.max(dpmin[i - 1] * nums[i], nums[i]));
            dpmin[i] = Math.min(dpmin[i - 1] * nums[i], Math.min(dpmax[i - 1] * nums[i], nums[i]));
            sns = Math.max(sns, dpmax[i]);
        }
        return sns;
    }

    public static void main(String[] args) {
        int i = new MaximumProductSubarray().maxProduct(new int[]{2, -5, -2, -4, 3});
        System.out.println(i);
    }


}
