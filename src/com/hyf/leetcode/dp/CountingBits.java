package com.hyf.leetcode.dp;

import java.util.Arrays;

/**
 * @Author huyufei on 2021/1/8
 * @Desc: TODO
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] count = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            String s = Integer.toBinaryString(i);
            count[i] = countOneChar(s);
        }
        return count;
    }

    public int countOneChar(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        int[] ints = countingBits.countBits(0);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }
}
