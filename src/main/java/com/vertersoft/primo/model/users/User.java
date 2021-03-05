package com.vertersoft.primo.model.users;

import com.vertersoft.primo.model.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String fullName;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role",
//        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
//        inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
//    private List<Role> roles;

    @Lob
    @ToString.Exclude
    private Byte[] userPhoto;

    @NotBlank
    @Size(min = 10, max = 13)
    @Column(unique = true)
    private String phoneNumber;

    @Email
    @Column(unique = true)
    private String email;


    @NotBlank
    private String password;

}
