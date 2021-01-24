package com.hyf.leetcode.thread;

/**
 * 死锁避免
 * 首先4个理论基础
 * 1. 互斥条件
 * 2. 不可剥夺条件
 * 3. 请求和保持条件
 * 4. 循环等待条件
 * 当碰到两个synchronized嵌套的时候（有时候嵌套不容易被肉眼观察到）
 * 考虑使用 lock.tryLock或者一次性将锁资源保存起来，用时来申请
 * @Author huyufei on 2021/1/8
 * @Desc: TODO
 */
public class Transfer {
    public static void main(String[] args) {

    }
}
