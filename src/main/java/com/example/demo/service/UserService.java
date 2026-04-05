package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;


    // Manual constructor injection (replacement for Lombok)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {

        return userRepository.findAll();
    }


    public void updateUserStatus(Long id, boolean active) {

        User user = userRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        user.setActive(active);

        userRepository.save(user);
    }


    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }
}