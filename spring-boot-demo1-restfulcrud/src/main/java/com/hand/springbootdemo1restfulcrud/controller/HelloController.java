package com.hand.springbootdemo1restfulcrud.controller;

import com.hand.springbootdemo1restfulcrud.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    //没必要在Controller中添加这种没有业务处理的转发页面方法--直接给MvcConfigurer加入到addViewController
//    @RequestMapping({"/","index.html"})
//    public String index(){
//        //templates模板引擎拼串prefix="/templates"  suffix=".html"
//        return "login";
//    }


    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam String username) {
        if (username.equals("aaa")) {
            //抛出自定义异常
            throw new UserNotExistException();
        }
        return "HelloWorld222";
    }

    //    @ResponseBody     //要想进入视图解析器，不能夹@ResponseBody注解
    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        //从classpath:templates/success.html找
        map.put("hello", "<h1>后端数据</h1>");
        map.put("users", Arrays.asList("dragon1", "dragon2"));
        Map<String, Object> users2 = new HashMap<>();
        users2.put("name1", "user2Dragon1");
        users2.put("age1", 23);
        map.put("users2", users2);
        return "success";
    }

}
