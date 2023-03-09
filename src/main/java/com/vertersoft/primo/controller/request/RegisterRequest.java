package com.vertersoft.primo.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterRequest {

    private String firstName;

    private String lastName;

    private String photo;

    @Size(min = 10, max = 13)
    private String phoneNumber;

    @Size(max = 50)
    @Email
    private String email;

    @Size(min = 6, max = 40)
    @NotBlank
    private String password;
}
