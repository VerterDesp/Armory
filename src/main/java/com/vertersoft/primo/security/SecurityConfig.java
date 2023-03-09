package com.vertersoft.primo.security;

import com.vertersoft.primo.security.jwt.JwtAuthenticationEntryPoint;
import com.vertersoft.primo.security.jwt.JwtRequestFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtRequestFilter jwtRequestFilter;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .cors()
            .and()
                .csrf()
                .disable()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
            .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .authorizeHttpRequests((requests) -> requests
                  .requestMatchers("/auth/**", "/handgun", "/all").permitAll()
                  .requestMatchers("/admin/**").hasRole("ADMIN")
                  .requestMatchers("/moder/**").hasRole("MODERATOR")
                  .requestMatchers("/client/**").hasRole("CLIENT")
                  .anyRequest().authenticated())
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }
}
