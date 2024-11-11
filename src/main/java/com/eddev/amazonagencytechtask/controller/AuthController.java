package com.eddev.amazonagencytechtask.controller;

import com.eddev.amazonagencytechtask.dto.AuthDto;
import com.eddev.amazonagencytechtask.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final SecurityContextLogoutHandler logoutHandler;

    @PostMapping("/sign-up")
    public ResponseEntity<String> register(@RequestBody AuthDto request) {
        authService.signUp(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> login(@RequestBody AuthDto request, HttpServletRequest servletRequest, HttpServletResponse response) {
        authService.signIn(request, servletRequest, response);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> performLogout(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        logoutHandler.logout(request, response, authentication);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
