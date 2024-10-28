package com.project.newsletter.service;

import com.project.newsletter.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        log.info("loadUserByUsername >>");
        Optional<User> user = userService.getUser(emailId);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.get().getEmailId())
                .password(user.get().getPassword())
                .roles(user.get().getRole())
                .build();
    }
}
