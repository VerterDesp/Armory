package com.vertersoft.primo.service;

import com.vertersoft.primo.controller.request.RegisterRequest;
import com.vertersoft.primo.exception.AlreadyExistsException;
import com.vertersoft.primo.exception.CustomNotFoundException;
import com.vertersoft.primo.exception.WrongFormatException;
import com.vertersoft.primo.model.client.Client;
import com.vertersoft.primo.model.client.ClientDetail;
import com.vertersoft.primo.model.client.role.Role;
import com.vertersoft.primo.model.client.role.RoleType;
import com.vertersoft.primo.repository.ClientRepository;
import com.vertersoft.primo.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientService implements UserDetailsService {

    private final ClientRepository clientRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passEncoder;

    @Override
    public ClientDetail loadUserByUsername(String login) throws UsernameNotFoundException {
        Client client = isNumber(login) ? this.findByPhoneNumber(login) : this.findByEmail(login);
        return ClientDetail.build(client);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public void save(RegisterRequest registerRequest) {
        Optional.ofNullable(registerRequest.getEmail())
                .ifPresent(email -> {
                    if (!email.isEmpty() && clientRepository.existsByEmail(email)) {
                        throw new AlreadyExistsException("Email already in use!");
                    }
                });

        Optional.ofNullable(registerRequest.getPhoneNumber())
                .ifPresent(num -> {
                    if (isNumber(num)) {
                        if (!num.isEmpty() && clientRepository.existsByPhoneNumber(num)) {
                            throw new AlreadyExistsException("Number already in use!");
                        }
                    } else throw new WrongFormatException("Wrong number format!");
                });

        Client client = new Client(registerRequest.getFirstName(),
                registerRequest.getLastName(),
                Collections.singletonList(this.findUserRole()),
                registerRequest.getPhoto(),
                registerRequest.getPhoneNumber(),
                registerRequest.getEmail(),
                passEncoder.encode(registerRequest.getPassword()));
        clientRepository.save(client);
    }

    public Role findUserRole() {
        return roleRepository.findById(RoleType.ROLE_CLIENT.name())
                .orElseThrow(() -> new CustomNotFoundException(String.format
                        ("No role \"%s\" found", RoleType.ROLE_CLIENT)));
    }

    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format
                                ("No client with email \"%s\" found", email)));
    }

    public Client findByPhoneNumber(String phoneNumber) {
        return clientRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format
                                ("No client with number - \"%s\" found", phoneNumber)));
    }

    public boolean isNumber(String login) {
         return login != null && login.chars().allMatch(Character::isDigit);
    }
}
