package com.ooliuyue.springboot_aoptest.utils;


import com.ooliuyue.springboot_aoptest.common.Result;
import com.ooliuyue.springboot_aoptest.enums.EnumResultCode;

/**
 * @Auther: ly
 * @Date: 2018/12/27 11:52
 */

public class ResponseMsgUtil {
    /**
     * 根据消息码等生成接口返回对象
     * @param code 结果返回码
     * @param msg  结果返回消息
     * @param data 数据对象
     * @param <T>
     * @return
     */
    public static <T> Result<T> builderResponse (int code, String msg, T data) {
        Result<T> res = new Result<>();
        res.setData(data);
        res.setResCode(code);
        res.setResMsg(msg);
        return res;
    }

    public static <T> Result<T> exception(){
        return builderResponse(EnumResultCode.INTERNAL_SERVER_ERROR.getCode(),"服务异常",null);
    }

}
