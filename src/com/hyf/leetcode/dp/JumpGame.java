package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2020/12/28
 * @Desc: TODO
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
//        确定状态，设dp[i]表示是否能跳到i，那么需要只需要知道dp[j]能否跳到,且0<=j<i,并且i-j<=a[j]
//        需要知道能否跳到dp[j]，那么就是一个字问题，需要枚举之前的dp[0....j] 0<=j<i
//        开数组
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        boolean b = new JumpGame().canJump(new int[]{3, 2, 1, 0, 4});
        System.out.println(b);
    }
}
