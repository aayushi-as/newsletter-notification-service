package com.project.newsletter.controller;

import com.project.newsletter.dto.LoginRequest;
import com.project.newsletter.dto.LoginResponse;
import com.project.newsletter.jwt.JwtUtil;
import com.project.newsletter.model.Admin;
import com.project.newsletter.service.AdminDetailsServiceImpl;
import com.project.newsletter.service.AdminService;
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
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminDetailsServiceImpl adminDetailsService;

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
    public ResponseEntity<?> createAdminAccount(@Valid @RequestBody Admin admin) {
        log.info("createAdminAccount >>");
        Optional<Admin> existingEmail = adminService.getAdmin(admin.getEmailId());

        if (existingEmail.isPresent()) {
            log.warn("Email Id is already present {}", existingEmail.get().getEmailId());
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminService.registerAdmin(admin);
        log.info("Registration of admin is successful! {}", admin.getFullName());

        return ResponseEntity.status(HttpStatus.CREATED).body("Admin registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> adminLogin(@Valid @RequestBody LoginRequest loginRequest, HttpServletResponse response) throws AuthenticationException {
        Optional<Admin> admin = adminService.getAdmin(loginRequest.getEmailId());
        if (admin.isEmpty()) {
            throw new UsernameNotFoundException("Admin not found!");
        }

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmailId(),
                loginRequest.getPassword()));


        UserDetails userDetails = adminDetailsService.loadUserByUsername(loginRequest.getEmailId());
        log.debug("Received user details");

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
                new LoginResponse(admin.get().getEmailId(), admin.get().getFullName())
        );
    }

}
