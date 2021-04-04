package com.vertersoft.primo.service;

import com.vertersoft.primo.controller.request.RegisterRequest;
import com.vertersoft.primo.exception.AlreadyExistsException;
import com.vertersoft.primo.exception.CustomNotFoundException;
import com.vertersoft.primo.model.users.role.ERole;
import com.vertersoft.primo.model.users.role.Role;
import com.vertersoft.primo.model.users.User;
import com.vertersoft.primo.model.users.UserDetail;
import com.vertersoft.primo.repository.RoleRepository;
import com.vertersoft.primo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = isNumber(login) ? this.findByPhoneNumber(login) : this.findByEmail(login);
        return UserDetail.build(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(RegisterRequest registerRequest) {
        Optional.ofNullable(registerRequest.getEmail())
                .ifPresent(email -> {
                    if (userRepository.existsByEmail(email)) {
                        throw new AlreadyExistsException("Email already in use!");
                    }
                });

        Optional.ofNullable(registerRequest.getPhoneNumber())
                .ifPresent(num -> {
                    if (userRepository.existsByPhoneNumber(num)) {
                        throw new AlreadyExistsException("Number already in use!");
                    }
                });

        User user = new User(registerRequest.getFirstName(),
                registerRequest.getLastName(),
                Arrays.asList(this.findUserRole()),
                registerRequest.getPhoto(),
                registerRequest.getPhoneNumber(),
                registerRequest.getEmail(),
                passEncoder.encode(registerRequest.getPassword()));
        userRepository.save(user);
    }

    public Role findUserRole() {
        return roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new CustomNotFoundException(String.format
                        ("No role \"%s\" found", ERole.ROLE_USER.toString())));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format
                                ("No user with email \"%s\" found", email)));
    }

    public User findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format
                                ("No user with number - \"%s\" found", phoneNumber)));
    }

    public boolean isNumber(String login) {
        assert login != null;
        return login.chars().allMatch(Character::isDigit);
    }
}
