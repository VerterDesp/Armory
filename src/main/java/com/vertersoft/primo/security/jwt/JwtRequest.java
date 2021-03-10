package com.vertersoft.primo.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
