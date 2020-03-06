package com.hand.springbootdemo1restfulcrud.controller;

import com.hand.springbootdemo1restfulcrud.entity.User;
import com.hand.springbootdemo1restfulcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list")
    public List<User> list() {
        return userRepository.findAll();
    }

    @RequestMapping("/query")
    public User queryUserById(Long id) {
        return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    /**
     * @param user          : @Validated(开启javax.validation的校验)，
     * @param bindingResult : BindingResult:获取@Validated发生的异常
     * @return User
     */
    @PostMapping("/create")
    public User create(@Validated @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException(bindingResult.toString());
        }
        return userRepository.save(user);
    }


    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
