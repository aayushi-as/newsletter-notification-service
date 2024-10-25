package com.project.newsletter.service;

import com.project.newsletter.model.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class AdminDetailsServiceImpl implements UserDetailsService {

    private final AdminService adminService;

    public AdminDetailsServiceImpl(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        log.info("loadUserByUsername >>");
        Optional<Admin> admin = adminService.getAdmin(emailId);
        if (admin.isEmpty()) {
            throw new UsernameNotFoundException("Admin not found!");
        }

        return User.builder()
                .username(admin.get().getEmailId())
                .password(admin.get().getPassword())
                .roles("ADMIN")
                .build();
    }
}
