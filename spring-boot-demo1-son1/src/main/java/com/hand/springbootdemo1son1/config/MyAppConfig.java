package com.hand.springbootdemo1son1.config;

import com.hand.springbootdemo1son1.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration：指明当前类是一个配置类；替代Spring中的配置文件
 */
@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中；容器中的默认id就是方法名
    @Bean
    public HelloService helloService() {
        System.out.println("@Bean给容器中添加组件");
        return new HelloService();
    }
}
