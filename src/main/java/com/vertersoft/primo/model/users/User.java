package com.vertersoft.primo.model.users;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

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
    private String password;

    public User(String fullName,
                List<Role> roles,
                Byte[] photo,
                String phoneNumber,
                @Email String email,
                @NotBlank String password) {
        this.fullName = fullName;
        this.roles = roles;
        this.photo = photo;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }
}
