package com.ooliuyue.springboot_aoptest.controller;

import com.ooliuyue.springboot_aoptest.annotation.ParamCheck;
import com.ooliuyue.springboot_aoptest.common.Result;
import com.ooliuyue.springboot_aoptest.enums.EnumResultCode;
import com.ooliuyue.springboot_aoptest.utils.ResponseMsgUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ly
 * @Date: 2018/12/27 11:43
 */
@RestController

public class HelloController {
    /**
     * 测试@RequestParam注解
     * @param name
     * @return
     */
    @GetMapping("/hello1")
    public Result<String> hello1(@RequestParam String name){
        return ResponseMsgUtil.builderResponse(EnumResultCode.SUCCESS.getCode(),"请求成功","Hello," + name);
    }

    /**
     * 测试@ParamCheck注解
     * @param name
     * @return
     */
    @GetMapping("/hello2")
    public Result<String> hello2(@ParamCheck String name){
        return ResponseMsgUtil.builderResponse(EnumResultCode.SUCCESS.getCode(),"请求成功","Hello," + name);
    }

    /**
     * 测试@ParamCheck 和 @RequestParam
     *
     * @param name
     * @return
     */
    @GetMapping("/hello3")
    public Result<String> hello3(@ParamCheck @RequestParam String name){
        return ResponseMsgUtil.builderResponse(EnumResultCode.SUCCESS.getCode(),"请求成功","Hello," + name);
    }

}
