package com.hand.springbootdemo1datajpa.entity;

import lombok.Data;

import javax.persistence.*;

//使用JPA注解配置映射关系
@Entity //声明这是一个实体类(和数据库表映射的类)
@Table(name = "tbl_user")//@Table指定和哪个表对应,默认对应的表名称是类名小写(user)
@Data
public class User {
    @Id //声明这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;

    @Column(name = "last_name", length = 50) //和数据库表对应的列
    private String lastName;

    @Column //默认列名就是属性名
    private String email;
}
