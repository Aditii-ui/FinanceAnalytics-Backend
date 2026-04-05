package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http

                // Disable CSRF for APIs + H2 console
                .csrf(csrf -> csrf.disable())

                // Allow H2 console frame rendering
                .headers(headers ->
                        headers.frameOptions(frame -> frame.disable())
                )

                .authorizeHttpRequests(auth -> auth

                        // Allow authentication APIs
                        .requestMatchers("/auth/**")
                        .permitAll()

                        // Allow H2 console access
                        .requestMatchers("/h2-console/**")
                        .permitAll()

                        // Dashboard access
                        .requestMatchers("/dashboard/**")
                        .hasAnyRole("VIEWER", "ANALYST", "ADMIN")

                        // Records access
                        .requestMatchers("/records/**")
                        .hasAnyRole("ANALYST", "ADMIN")

                        // User management access
                        .requestMatchers("/users/**")
                        .hasRole("ADMIN")

                        // Any other request must be authenticated
                        .anyRequest()
                        .authenticated()
                );

        return http.build();
    }
}