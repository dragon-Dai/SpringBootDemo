package com.hand.springbootdemo1logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDemo1LoggingApplicationTests {

    //记录器
    Logger logger = LoggerFactory.getLogger(SpringBootDemo1LoggingApplicationTests.class);

    @Test
    void contextLoads() {
        //日志级别  trace-->debug-->info-->warn-->error
        //可以调整日志级别;  日志只会输出改级别以及改级别之后的信息
        //默认输出info（root）级别
        //trace
        logger.trace("这是trace日志");
        //debug
        logger.debug("这是debug日志");
        //info
        logger.info("这是info日志");
        //警告--例如：方法返回值不是预期的值
        logger.warn("这是warn日志");
        //错误--例如：程序出现异常
        logger.error("这是error日志");
    }

}
