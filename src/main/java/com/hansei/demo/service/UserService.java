package com.hansei.demo.service;

import com.hansei.demo.entity.User;
import com.hansei.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User saveUser(User user) {
        return userRepository.save(user);
    }


    public User getUserId(int id) {
        return userRepository.findById(id).get();
    }


    public User getUserName(String name) {
        return userRepository.findByName(name).get();
    }
}
