package com.vertersoft.primo.controller;

import com.vertersoft.primo.dto.UserDTO;
import com.vertersoft.primo.security.jwt.JwtRequest;
import com.vertersoft.primo.security.jwt.JwtResponse;
import com.vertersoft.primo.security.jwt.JwtTokenUtil;
import com.vertersoft.primo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class JwtAuthController {

    private final AuthenticationManager authManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;

    @PostMapping("/sign_in")
    public ResponseEntity<JwtResponse> login(@RequestBody @Valid JwtRequest authRequest) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String token = jwtTokenUtil.generateToken(authRequest.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/sign_up")
    public ResponseEntity<String> register(@RequestBody @Valid UserDTO user) {
        userService.save(user);
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }

}
