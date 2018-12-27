package com.ooliuyue.springboot_aoptest.common;

/**
 * @Auther: ly
 * @Date: 2018/12/27 11:57
 */

public class Result<T> {
    public Integer getResCode() {
        return resCode;
    }

    public void setResCode(Integer resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private Integer resCode;
    private String resMsg;
    private T data;
}
