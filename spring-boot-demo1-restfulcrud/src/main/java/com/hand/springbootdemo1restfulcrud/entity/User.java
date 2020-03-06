package com.hand.springbootdemo1restfulcrud.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "DEMO_USER")
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank//用于字符串不能为空
    @Column
    private String name;
    @NotBlank
    @Column
    private String account;
    @NotBlank
    @Column
    private String pwd;
    @Range(max = 200, min = 0)
    @Column
    private Integer age;
    @Email
    private String email;
}
