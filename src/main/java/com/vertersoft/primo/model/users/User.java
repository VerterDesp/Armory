package com.vertersoft.primo.model.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vertersoft.primo.model.users.role.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "users")
public class User implements UserBasic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String firstName;

    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @Lob
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Byte[] photo;

    @Column(unique = true)
    private String phoneNumber;

    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @JsonIgnore
    private String password;

    public User(String firstName,
                String secondName,
                List<Role> roles,
                Byte[] photo,
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
