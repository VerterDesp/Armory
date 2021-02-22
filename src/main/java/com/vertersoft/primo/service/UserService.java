package com.vertersoft.primo.service;

import com.vertersoft.primo.exception.CustomNotFoundException;
import com.vertersoft.primo.model.users.User;
import com.vertersoft.primo.repository.RoleRepository;
import com.vertersoft.primo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    //private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        if ("javainuse".equals(login)) {
            return new org.springframework.security.core.userdetails.User(
                    "javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + login);
        }
    }

//    public User save(User user) {
//        Optional<Role> userRole = Optional.ofNullable(roleRepository.findByName("ROLE_USER"));
//        if (userRole.isPresent()) {
//            user.setRoles(userRole.get());
//        } else {
//            throw new RoleNotFoundException(String
//                    .format("Role %s not found",userRole));
//        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
//    }

//    @Transactional
//    public User getUser(Long id) {
//        Optional<User> user = userRepository.findById(id);
//        if (user.isPresent()) {
//            return user.get();
//        } else {
//            throw new CustomNotFoundException(String
//                    .format("No user with id - \"%d\" found", id));
//        }
//    }
//
//    @Transactional
//    public User findByPhoneNumber(String phoneNumber) {
//        Optional<User> user = Optional
//                .ofNullable(userRepository.findByPhoneNumber(phoneNumber));
//        if(user.isPresent()) {
//            return user.get();
//        } else {
//            throw new CustomNotFoundException(String
//                    .format("No user with number - \"%s\" found", phoneNumber));
//        }
//    }
//
//    @Transactional
//    public User findByPhoneNumberAndPassword(String phoneNumber, String password) {
//        Optional<User> user = Optional
//                .ofNullable(userRepository.findByPhoneNumberAndPassword(phoneNumber, password));
//        if (user.isPresent()) {
//            return userRepository.findByPhoneNumberAndPassword(phoneNumber, password);
//        } else {
//            throw new CustomNotFoundException("Bad credentials");
//        }
//    }
}
