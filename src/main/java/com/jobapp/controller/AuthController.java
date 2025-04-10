package com.jobapp.controller;

import com.jobapp.dto.AuthRequest;
import com.jobapp.dto.AuthResponse;
import com.jobapp.model.User;
import com.jobapp.service.UserService;
import com.jobapp.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, 
                        UserService userService, 
                        JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        String token = jwtUtil.generateToken(userService.loadUserByUsername(savedUser.getEmail()));
        return ResponseEntity.ok(new AuthResponse(token, savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(), 
                authRequest.getPassword()
            )
        );
        final UserDetails userDetails = userService.loadUserByUsername(authRequest.getEmail());
        final String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(token, (User) userDetails));
    }
}