package com.hyf.leetcode.future;

public interface ResponseCallback {

    void done(Object response);


    void caught(Throwable exception);

}