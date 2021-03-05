package com.vertersoft.primo.security.jwt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class JwtResponse {
    private final String token;
}
