package com.hand.springbootdemo1son1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Value("${person.first-name")
    private String name;

    @ResponseBody
    @RequestMapping("/hello")       //http://localhost:8080/hello
    public String hello() {
        return "hello";
    }

    @RequestMapping("/sayHello")
    public String sayHello() {
        return "sayHello" + name;
    }
}
