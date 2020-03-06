package com.hand.dragondaispringbootautoconfigurer.service.config;

import com.hand.dragondaispringbootautoconfigurer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication    //web应用才生效
@EnableConfigurationProperties(value = HelloProperties.class)   //使HelloProperties生效，相当于把HelloProperties加入到IOC容器
public class HelloServiceAutoConfiguration {

    @Autowired
    HelloProperties helloProperties;

    @Bean
    public HelloService helloService() {
        HelloService helloService = new HelloService();
        //将自动导入的helloProperties赋入helloService中
        helloService.setHelloProperties(helloProperties);
        return helloService;
    }
}
