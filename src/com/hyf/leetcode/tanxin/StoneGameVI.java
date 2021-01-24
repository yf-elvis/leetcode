package com.hyf.leetcode.tanxin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author huyufei on 2021/1/18
 * @Desc: TODO
 * <p>
 * 输入：aliceValues = [2,4,3], bobValues = [1,6,7]
 * 输出：-1
 * 解释：
 * 不管 Alice 怎么操作，Bob 都可以得到比 Alice 更高的得分。
 * 比方说，Alice 拿石子 1 ，Bob 拿石子 2 ， Alice 拿石子 0 ，Alice 会得到 6 分而 Bob 得分为 7 分。
 * Bob 会获胜。
 */
public class StoneGameVI {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
//        先计算每个石子的价值和，然后从大到小排序
        int len = aliceValues.length;
        int[][] sum = new int[len][3];
        for (int i = 0; i < len; i++) {
            sum[i] = new int[]{aliceValues[i] + bobValues[i], aliceValues[i], bobValues[i]};
        }
        Arrays.sort(sum, (o1, o2) -> o2[0] - o1[0]);
        int a = 0;
        int b = 0;
        for (int i = 0; i < len; i++) {
            if ((i & 1) == 0) {
                a = a + sum[i][1];
            } else {
                b = b + sum[i][2];
            }
        }
        return Integer.compare(a, b);
    }

    public static void main(String[] args) {
        int i = new StoneGameVI().stoneGameVI(new int[]{2, 4, 3}, new int[]{1, 6, 7});
        System.out.println(i);
    }
}
