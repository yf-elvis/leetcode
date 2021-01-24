package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2021/1/16
 * @Desc: TODO
 */
public class StoneGameV {
    private int[][] dp;

    public int stoneGameV(int[] stoneValue) {
        /**
         * 设dp[l][r]代表Alice面对[l...r]石子的时候获得的最大分数
         * 枚举每个分割点i，当sum[l..i]>sum[i+1..r]时候，Bob去掉sum[l...i]
         * 此时Alice只能 从stoneValue[i+1,r]取，那么递归查找dp[i+1,r]
         */
        if(stoneValue.length==0){
            return 0;
        }
        int len = stoneValue.length;
        dp = new int[len][len];
        dp[0][0] = 0;
        return dfs(stoneValue, 0, len - 1);
    }

    public int dfs(int[] stoneValue, int start, int end) {

        if (start == end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
//        求出前缀和
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += stoneValue[i];
        }

        int suml = 0;
        int sumr = 0;
        for (int i = start; i < end; i++) {
            suml += stoneValue[i];
            sumr = sum - suml;
            if (suml < sumr) {
//                丢弃右边部分
                dp[start][end] = Math.max(dp[start][end], dfs(stoneValue, start, i) + suml);
            } else if (suml > sumr) {
//                丢弃左边的
                dp[start][end] = Math.max(dp[start][end], dfs(stoneValue, i + 1, end) + sumr);
            } else {
                dp[start][end] = Math.max(dp[start][end], Math.max(dfs(stoneValue, start, i), dfs(stoneValue, i + 1, end)) + suml);
            }
        }
        return dp[start][end];
    }

    public static void main(String[] args) {
        int i = new StoneGameV().stoneGameV(new int[]{});
        System.out.println(i);
    }
}
