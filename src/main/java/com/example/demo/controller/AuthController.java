package com.example.demo.controller;

import com.example.demo.dto.LoginRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;


    // Manual constructor injection
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(
            @RequestBody RegisterRequestDto requestDto) {

        authService.registerUser(requestDto);

        return ResponseEntity.ok("User registered successfully");
    }


    @PostMapping("/login")
    public ResponseEntity<String> loginUser(
            @RequestBody LoginRequestDto requestDto) {

        String token = authService.loginUser(requestDto);

        return ResponseEntity.ok(token);
    }
}