package com.vertersoft.primo.controller;

import com.vertersoft.primo.controller.request.RegisterRequest;
import com.vertersoft.primo.model.users.UserDetail;
import com.vertersoft.primo.controller.request.LoginRequest;
import com.vertersoft.primo.controller.response.JwtResponse;
import com.vertersoft.primo.security.jwt.JwtTokenUtil;
import com.vertersoft.primo.service.UserService;
import com.vertersoft.primo.controller.response.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;

    @PostMapping("/sign_in")
    public ResponseEntity<JwtResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String token = jwtTokenUtil.generateToken(loginRequest.getUsername());
        UserDetail userDetails = (UserDetail) auth.getPrincipal();
        List<String> rolesFromUserDetail = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(token, userDetails.getFirstName(),
                                                        userDetails.getLastName(),
                                                        userDetails.getPhoneNumber(),
                                                        userDetails.getEmail(),
                                                        rolesFromUserDetail));
    }

    @PostMapping("/sign_up")
    public ResponseEntity<MessageResponse> register(@RequestBody @Valid RegisterRequest user) {
        userService.save(user);
        return new ResponseEntity<>(new MessageResponse("User created!"), HttpStatus.CREATED);
    }

}
