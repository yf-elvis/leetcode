package com.hyf.leetcode.thread;

import java.text.NumberFormat;
import java.util.concurrent.CountDownLatch;

/**
 * @Author huyufei on 2020/10/28
 * @Desc: TODO
 */
public class CountDownTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.countDown();
        countDownLatch.countDown();

        final NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(20);
        nf.setMaximumFractionDigits(0);
        nf.setGroupingUsed(false);
        String format = nf.format(43434243);
        System.out.println(format);
    }
}
