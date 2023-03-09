package com.vertersoft.primo.controller.response;

import java.util.List;


public record JwtResponse(String token,
                          String firstName,
                          String lastName,
                          String phoneNumber,
                          String email,
                          List<String> roles) {
}
