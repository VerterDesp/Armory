package com.vertersoft.primo.service;

import com.vertersoft.primo.exception.CustomNotFoundException;
import com.vertersoft.primo.model.Role;
import com.vertersoft.primo.model.users.User;
import com.vertersoft.primo.repository.RoleRepository;
import com.vertersoft.primo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
       User user = this.findByPhoneNumber(login);
       return new org.springframework.security.core.userdetails.User(
               user.getPhoneNumber(), user.getPassword(), new ArrayList<>());
    }

    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void save(User user) {
//        Role userRole = roleRepository
//                .findByName("ROLE_USER")
//                .orElseThrow(() ->
//                        new CustomNotFoundException(
//                                String.format("Role %s not found", "ROLE_USER")));
//        user.setRoles(Collections.singletonList(userRole));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new CustomNotFoundException(String.format
                                ("No user with id - \"%d\" found", id)));
    }

    @Transactional
    public User findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() ->
                        new CustomNotFoundException(String.format
                                ("No user with number - \"%s\" found", phoneNumber)));
    }

    @Transactional
    public User findByPhoneNumberAndPassword(String phoneNumber, String password) {
        return userRepository.findByPhoneNumberAndPassword(phoneNumber, password)
                .orElseThrow(() ->
                        new CustomNotFoundException("Bad credentials"));
    }
}
