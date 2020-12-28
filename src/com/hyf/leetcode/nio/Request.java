package com.hyf.leetcode.nio;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author huyufei on 2020/11/16
 * @Desc: TODO
 */
public class Request implements Serializable {

    private static final long serialVersionUID = 3510236567486415844L;

    private static AtomicLong reqCount = new AtomicLong(0);

    private int mId;

    

}
