package com.example.eventmoa.domain.user.presentation.dto.request;

import lombok.Getter;

@Getter
public class UserLoginRequest {
    private String username;
    private String password;
}
