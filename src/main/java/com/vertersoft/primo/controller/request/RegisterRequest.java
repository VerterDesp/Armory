package com.vertersoft.primo.controller.request;

import com.vertersoft.primo.model.users.UserBasic;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class RegisterRequest implements UserBasic {

    private String firstName;

    private String lastName;

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
