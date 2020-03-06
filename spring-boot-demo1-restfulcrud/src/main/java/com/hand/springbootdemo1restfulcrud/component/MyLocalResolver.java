package com.hand.springbootdemo1restfulcrud.component;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Objects;

/**
 * 自定义区域信息解析器 implements LocaleResolver
 */
@Component
public class MyLocalResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取url参数
        String language = httpServletRequest.getParameter("language");
        System.out.println("language:" + language);
        //获取默认的Local信息（http响应头中的local信息）
        Locale locale = Locale.getDefault();
//        if (language != null && !language.equals("")) {
        if (!StringUtils.isEmpty(language)) {
            String[] split = language.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
