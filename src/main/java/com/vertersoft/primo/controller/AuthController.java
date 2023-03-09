package com.vertersoft.primo.controller;

import com.vertersoft.primo.controller.request.LoginRequest;
import com.vertersoft.primo.controller.request.RegisterRequest;
import com.vertersoft.primo.controller.response.JwtResponse;
import com.vertersoft.primo.model.client.ClientDetail;
import com.vertersoft.primo.security.jwt.JwtTokenUtil;
import com.vertersoft.primo.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final ClientService clientService;

    @PostMapping("/sign_in")
    @ResponseStatus(HttpStatus.OK)
    public JwtResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String token = jwtTokenUtil.generateToken(loginRequest.getUsername());
        ClientDetail clientDetail = (ClientDetail) auth.getPrincipal();
        List<String> rolesFromUserDetail = clientDetail.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return new JwtResponse(token, clientDetail.getFirstName(), clientDetail.getLastName(),
          clientDetail.getPhoneNumber(),
          clientDetail.getEmail(),
          rolesFromUserDetail);
    }

    @PostMapping("/sign_up")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@RequestBody @Valid RegisterRequest client) {
        clientService.save(client);
        return "Client created!";
    }

}
