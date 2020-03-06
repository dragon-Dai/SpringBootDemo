package com.hand.springbootdemo1datamybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.hand.springbootdemo1datamybatis.mapper")
@SpringBootApplication
public class SpringBootDemo1DataMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo1DataMybatisApplication.class, args);
    }

}
