package com.hand.springbootdemo1son1;

import com.hand.springbootdemo1son1.bean.Person;
import com.hand.springbootdemo1son1.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * SpringBoot的单元测试
 * <p>
 * 可以在测试期间，进行自动注入的功能
 */
@SpringBootTest
class SpringBootDemo1Son1ApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    void testHelloService() {
        boolean boo = ioc.containsBean("helloService");
        System.out.println(boo);
    }
}
