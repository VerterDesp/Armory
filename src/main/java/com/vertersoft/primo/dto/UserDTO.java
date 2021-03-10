package com.vertersoft.primo.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    @Size(min = 2, max = 50)
    private String fullName;

    private Byte[] photo;

    @Size(min = 10, max = 13)
    private String phoneNumber;

    @Email
    private String email;

    @Size(min = 8, max = 50)
    @NotBlank
    private String password;
}
