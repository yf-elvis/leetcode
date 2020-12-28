package com.hyf.leetcode.future;

/**
 * @Author huyufei on 2020/11/15
 * @Desc: TODO
 */
public interface ResponseFuture {
    Object get() throws Exception;

    Object get(int timeoutInMillis) throws Exception;

    void setCallback(ResponseCallback responseCallback);

    boolean isDone();
}
