package com.login.login.dto;

import lombok.Data;

@Data
public class AuthResponseDto {
    String username;
    String password;
    String token;
    String refreshToken;
}
