package com.hand.springbootdemo1son1.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将application.yml配置的值映射到组件中
 *
 * @ConfigurationPropertions：告诉SpringBoot将本类中的所有属性和配置文件的相关配置进行绑定 只有当这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能
 * @ConfigurationProperties(prefix = "person"):默认是从全局配置文件中读取的
 */
@PropertySource(value = {"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix = "person")
@Validated  //对属性值进行校验
public class Person {
    /**
     * <bean class="Person">
     * <properties name="firstName" value="字面量/${key}从环境变量、配置文件中获取值/#{spEL}：可以计算"></properties>
     * </bean>
     */
    @Value("${person.first-name}")
//    @Email  //必须在类上添加 @Validated 注解     且    只对采用@ConfigurationProperties注解的类生效
    private String firstName;
    @Value("vDai")
    private String lastName;
    @Value("#{1+2}")
    private Integer age;
    private Boolean boss;
    private Date brithday;

    //    @Value("${person.map}")
    private Map<String, Object> map;
    private List<Object> list;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", brithday=" + brithday +
                ", map=" + map +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
