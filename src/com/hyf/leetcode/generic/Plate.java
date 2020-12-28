package com.hyf.leetcode.generic;

/**
 * @Author huyufei on 2020/11/15
 * @Desc: TODO
 */
public class Plate<T> {
    private T item;
    public Plate(T t) {
        this.item = t;
    }

    public void set(T t) {
        this.item = t;
    }

    public T get(){
        return item;
    }
}
