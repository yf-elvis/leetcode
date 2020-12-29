package com.hyf.leetcode.dp;

/**
 * @Author huyufei on 2020/12/29
 * @Desc: TODO
 */
public class CoinChangevII {
    //    跟定 amount面值的金额，能否用coins个硬币凑成amount
    public boolean isCoin(int[] coins, int amount) {
//        确定状态, dp[i] 表示能否凑成面值为i的金币，则要看i-coins[j]能否凑成或者i==coins[j]
        boolean[] dp = new boolean[amount + 1];
        dp[0] = false;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && (dp[i - coins[j]] || coins[j] == i)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        boolean coin = new CoinChangevII().isCoin(new int[]{2, 5, 7}, 101);
        System.out.println(coin);
    }
}
