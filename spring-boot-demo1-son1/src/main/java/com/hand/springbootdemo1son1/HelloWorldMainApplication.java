package com.hand.springbootdemo1son1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @SpringBootApplication 来标注一个主程序类，说明这是一个SpringBoot应用
 */
@SpringBootApplication
//@ImportResource(locations = {"classpath:beans.xml"})
public class HelloWorldMainApplication {
    public static void main(String[] args) {
        //启动Spring应用
        SpringApplication.run(HelloWorldMainApplication.class);
    }
}
