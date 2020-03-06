package com.hand.springbootdemo1restfulcrud.controller;

import com.hand.springbootdemo1restfulcrud.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    //@ExceptionHandler处理异常UserNotExistException
    //1.客户端和浏览器返回的都是json数据
//    @ExceptionHandler(value = UserNotExistException.class)
//    @ResponseBody
//    public Map<String,Object> handleUserNotException(Exception e){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code", "user.notexist");
//        map.put("message", e.getMessage());
//        return map;
//    }

    @ExceptionHandler(value = UserNotExistException.class)
//    @ResponseBody
    public String handleUserNotException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //传入我们自己的错误状态码 4xx,5xx
        /**
         * Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user.notexist");
        map.put("message", e.getMessage());

        //将我们自己自定义的数据存入到request域中
        request.setAttribute("ext", map);

        //转发到/error给    BasicErrorController处理
        return "forward:/error";
    }
}
