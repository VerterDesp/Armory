package com.vertersoft.primo.service;

import com.vertersoft.primo.dto.UserDTO;
import com.vertersoft.primo.exception.AlreadyExistsException;
import com.vertersoft.primo.exception.CustomNotFoundException;
import com.vertersoft.primo.exception.message.MessageResponse;
import com.vertersoft.primo.model.users.ERole;
import com.vertersoft.primo.model.users.Role;
import com.vertersoft.primo.model.users.User;
import com.vertersoft.primo.model.users.UserDetail;
import com.vertersoft.primo.repository.RoleRepository;
import com.vertersoft.primo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

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

    public void save(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail()))
            throw new AlreadyExistsException("Email already in use!");

        if (userRepository.existsByPhoneNumber(userDTO.getPhoneNumber()))
            throw new AlreadyExistsException("Number already in use!");

        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new CustomNotFoundException(String.format
                        ("No role \"%s\" found", ERole.ROLE_USER.toString())));

        User user = new User(userDTO.getFullName(),
                Arrays.asList(userRole),
                userDTO.getPhoto(),
                userDTO.getPhoneNumber(),
                userDTO.getEmail(),
                passEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);
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
        return login.chars().allMatch(Character::isDigit);
    }
}
