package org.kbotsk.auth.Dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}