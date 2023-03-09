package com.vertersoft.primo.model.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vertersoft.primo.model.client.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Client {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;

    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "client_role",
        joinColumns = @JoinColumn(name = "client_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    private String photo;

    @NotBlank
    private String phoneNumber;

    @Email
    private String email;

    @NotBlank
    @JsonIgnore
    private String password;

    public Client(String firstName,
                String secondName,
                List<Role> roles,
                String photo,
                String phoneNumber,
                @Email String email,
                @NotBlank String password) {
        this.firstName = firstName;
        this.lastName = secondName;
        this.roles = roles;
        this.photo = photo;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }
}
