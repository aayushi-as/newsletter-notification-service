package com.project.newsletter.controller;

import com.project.newsletter.dto.LoginRequest;
import com.project.newsletter.dto.LoginResponse;
import com.project.newsletter.jwt.JwtUtil;
import com.project.newsletter.model.User;
import com.project.newsletter.service.UserDetailsServiceImpl;
import com.project.newsletter.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/public/newsletter")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/ping")
    public String ping() {
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<?> createAccount(@Valid @RequestBody User user) {
        log.info("createAccount >>");
        Optional<User> existingEmail = userService.getUser(user.getEmailId());

        if (existingEmail.isPresent()) {
            log.warn("Email Id is already present {}", existingEmail.get().getEmailId());
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        log.info("Registration is successful! {}", user.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body("Registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest, HttpServletResponse response) throws AuthenticationException {
        Optional<User> user = userService.getUser(loginRequest.getEmailId());
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Account with this email id not found!");
        }

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmailId(),
                loginRequest.getPassword()));


        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmailId());
        log.debug("Received account details");

        final String jwt = jwtUtil.generateToken(userDetails);
        log.debug("Generated token");

        Cookie cookie = new Cookie("jwt", jwt);
        cookie.setHttpOnly(true);                       // Prevent JavaScript access
        cookie.setMaxAge(24 * 60 * 60);                 // Set cookie expiry (in seconds), adjust as needed
        cookie.setPath("/");                            // Set cookie path
//        cookie.setSecure(true);                       // Ensure cookie is transmitted only over HTTPS
        response.addCookie(cookie);

        log.debug("Cookie added");

        return ResponseEntity.ok(
                new LoginResponse(user.get().getEmailId(), user.get().getName(), user.get().getRole())
        );
    }

}
