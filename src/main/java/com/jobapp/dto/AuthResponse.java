package com.jobapp.dto;

import com.jobapp.model.User;
import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private User user;  // Frontend expects { token: string, user: { id, email, role } }
}