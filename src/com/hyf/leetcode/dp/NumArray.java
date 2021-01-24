package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2021/1/9
 * @Desc: TODO
 */
public class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int ans = 0;
        for (int k = i; k <= j; k++) {
            ans += nums[k];
        }
        return ans;
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        int i = numArray.sumRange(0, 5);
        System.out.println(i);
    }
}
