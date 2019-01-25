package com.example.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 添加全局异常处理
 *
 * @author 杨正
 */
@ControllerAdvice
public class GlobalDefaultException {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defaultException(HttpServletRequest request, Exception e) {
        return "服务器异常，请稍后重试！";
    }

}
