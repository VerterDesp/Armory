package com.vertersoft.primo.model.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UserDetail implements UserDetails, UserBasic {

    @JsonIgnore
    private Long id;

    private String firstName;

    private String lastName;

    private Collection<? extends GrantedAuthority> authorities;

    private Byte[] photo;

    private String phoneNumber;

    private String email;

    @JsonIgnore
    private String password;

    public static UserDetail build(User user) {
        List<GrantedAuthority> authoritiesFromRoles = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetail(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                authoritiesFromRoles,
                user.getPhoto(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getPassword()
        );
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
