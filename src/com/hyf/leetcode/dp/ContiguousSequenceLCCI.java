package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2021/1/10
 * @Desc: TODO
 */
public class ContiguousSequenceLCCI {
    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
//        设dp[i]为前i个最大子序和
//        dp[i] = dp[i-1] + nums[i]，但要注意，dp[i-1]+nums可能小于nums[i]，这时候需要nums[i]可以单独成一个子序列
//        所以d[i] = max(dp[i-1] + nums[i], nums[i]);
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
        int i = new ContiguousSequenceLCCI().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }
}
