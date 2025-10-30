package com.example.Farmer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Farmer.entity.User;
import com.example.Farmer.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User registerUser(User user) {
        User existingUser = repo.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new IllegalArgumentException("user already exist");
        }     
        return repo.save(user);
    }

}
