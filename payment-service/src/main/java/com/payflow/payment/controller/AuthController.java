package com.payflow.payment.controller;

import com.payflow.payment.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam String username,
            @RequestParam String password) {

        // Temporary login for learning/testing
        if ("admin".equals(username)
                && "admin123".equals(password)) {

            String token =
                    jwtService.generateToken(username);

            return ResponseEntity.ok(token);
        }

        return ResponseEntity
                .status(401)
                .body("Invalid username or password");
    }
}