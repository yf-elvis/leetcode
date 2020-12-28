package com.hyf.leetcode.sort;

/**
 * @Author huyufei on 2020/11/24
 * @Desc: TODO
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 7, -1, 2, 20, 15};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] <= nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
    }
}
