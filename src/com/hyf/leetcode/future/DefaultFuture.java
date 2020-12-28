package com.hyf.leetcode.future;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author huyufei on 2020/11/15
 * @Desc: TODO
 */
public class DefaultFuture implements ResponseFuture{


    @Override
    public Object get() throws Exception {
        return null;
    }

    @Override
    public Object get(int timeoutInMillis) throws Exception {
        return null;
    }

    @Override
    public void setCallback(ResponseCallback responseCallback) {

    }

    @Override
    public boolean isDone() {
        return false;
    }
}
