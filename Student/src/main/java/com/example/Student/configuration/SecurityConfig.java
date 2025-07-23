package com.example.Student.configuration;

package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Disable CSRF for POST/PUT testing from Postman
                .authorizeHttpRequests()
                .requestMatchers("/api/students/**").authenticated()  // Secure this path
                .anyRequest().permitAll()
                .and()
                .httpBasic(); // Use basic auth

        return http.build();
    }
}
