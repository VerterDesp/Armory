package com.vertersoft.primo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserDTO {

    @Size(min = 3, max = 50)
    private String fullName;

    private Byte[] photo;

    @Size(min = 10, max = 13)
    private String phoneNumber;

    @Size(max = 50)
    @Email
    private String email;

    @Size(min = 6, max = 40)
    @NotBlank
    private String password;
}
