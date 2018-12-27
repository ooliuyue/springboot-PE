package com.ooliuyue.springboot_aoptest.exception;

/**
 * 自定义异常类
 * @Auther: ly
 * @Date: 2018/12/27 09:55
 */

public class ParamIsNullException extends RuntimeException {


    private final String parameterName;
    private final String parameterType;

    public String getParameterName() {
        return parameterName;
    }

    public String getParameterType() {
        return parameterType;
    }


    public ParamIsNullException(String parameterName, String parameterType) {
        super("");
        this.parameterName = parameterName;
        this.parameterType = parameterType;
    }

    public String getMessage(){
        return "请求参数 "  + this.parameterName + " 不能为空 !";
    }

}
