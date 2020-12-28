package com.hyf.leetcode.nio;

import java.io.Serializable;

/**
 * @Author huyufei on 2020/11/16
 * @Desc: TODO
 */
public class RpcInvocation implements Serializable {


    private static final long serialVersionUID = -4360789823120653379L;

    private Class<?>[] parameterTypes;

    private Object[] args;

    private String methodName;


    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
