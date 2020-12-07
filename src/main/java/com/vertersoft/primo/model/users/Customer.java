package com.vertersoft.primo.model.users;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String firstName;

    private String lastName;

    @Lob
    @ToString.Exclude
    private Byte[] userPhoto;

    /*
     * Phone number is unique in the base
     */
    @Column(unique = true)
    private String phoneNumber;

    /*
     * Email is unique in the base
     */
    @Column(unique = true)
    private String email;

    private String password;

}
