package org.kbotsk.auth.Dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
