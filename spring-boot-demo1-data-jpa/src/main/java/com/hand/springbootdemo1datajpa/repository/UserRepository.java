package com.hand.springbootdemo1datajpa.repository;

import com.hand.springbootdemo1datajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<User,Integer>:User(数据库表对应的实体类),Interger(主键对应的实体类属性类型)
public interface UserRepository extends JpaRepository<User, Integer> {

}
