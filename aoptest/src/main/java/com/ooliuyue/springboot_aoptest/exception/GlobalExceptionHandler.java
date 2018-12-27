package com.ooliuyue.springboot_aoptest.exception;

import com.ooliuyue.springboot_aoptest.common.Result;
import com.ooliuyue.springboot_aoptest.enums.EnumResultCode;
import com.ooliuyue.springboot_aoptest.utils.ResponseMsgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @Auther: ly
 * @Date: 2018/12/27 13:50
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({MissingServletRequestParameterException.class, ParamIsNullException.class})
    public Result<String> getException(Exception ex){
        LOGGER.error("request Exception:", ex);
        return ResponseMsgUtil.builderResponse(EnumResultCode.FAIL.getCode(),ex.getMessage(),null);
    }


}
