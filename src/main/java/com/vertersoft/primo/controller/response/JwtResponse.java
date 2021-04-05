package com.vertersoft.primo.controller.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class JwtResponse {
    private final String token;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String email;
    private final List<String> roles;

}
