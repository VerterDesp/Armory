package com.vertersoft.primo.model.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class ClientDetail implements UserDetails {

    @JsonIgnore
    private UUID id;

    private String firstName;

    private String lastName;

    private Collection<? extends GrantedAuthority> authorities;

    private String photo;

    private String phoneNumber;

    private String email;

    @JsonIgnore
    private String password;

    public static ClientDetail build(Client client) {
        List<GrantedAuthority> authoritiesFromRoles = client.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getId()))
                .collect(Collectors.toList());

        return new ClientDetail(
          client.getId(),
          client.getFirstName(),
          client.getLastName(),
          authoritiesFromRoles,
          client.getPhoto(),
          client.getPhoneNumber(),
          client.getEmail(),
          client.getPassword()
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
