package com.hand.springbootdemo1restfulcrud.config;

import com.hand.springbootdemo1restfulcrud.component.LoginHandlerInterceptor;
import com.hand.springbootdemo1restfulcrud.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//实现WebMvcConfiguration接口可以扩展SpringMvc功能
@Configuration
//@EnableWebMvc     //全面接管SpringMvc
public class MyMvcConfig implements WebMvcConfigurer {

    //方法一：覆盖父类的addViewControllers方法
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /success 请求来到 success页面     --
        registry.addViewController("/success2").setViewName("success");
    }

    //方法二：注册一个WebMvcConfigurer对象到容器中
    //所有的WebMvcConfigurer都会一起起作用,将容器中所有的WebMvcConfigurer遍历一遍
    @Bean   //必须要加入到@Bean容器中
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                //防止表单重复提交,controller中使用重定向，在ViewController中添加视图映射
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //添加自己的拦截器-LoginHandlerInterceptor
                //addPathPatterns:添加拦截路径
                //excudePathPatterns:排除拦截路径--登录功能：主页、登录请求、静态资源请求
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html","/","/user/login","/asserts/**","/webjars/**");
            }
        };
        return webMvcConfigurer;
    }

    //添加自定义的区域化信息解析器到容器
    @Bean
    public LocaleResolver localResolver() {
        return new MyLocalResolver();
    }
}
