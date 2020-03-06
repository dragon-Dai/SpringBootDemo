package com.hand.springbootdemo1datajpa.controller;

import com.hand.springbootdemo1datajpa.entity.User;
import com.hand.springbootdemo1datajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserContoller {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/queryUser/{id}")
    public User queryUser(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            return new User();
        }
    }

    @RequestMapping("/insertUser")
    public User insertUser(User user) {
        User save = userRepository.save(user);
        return save;
    }
}
