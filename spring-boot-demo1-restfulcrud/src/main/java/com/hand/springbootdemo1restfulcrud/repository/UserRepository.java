package com.hand.springbootdemo1restfulcrud.repository;

import com.hand.springbootdemo1restfulcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
