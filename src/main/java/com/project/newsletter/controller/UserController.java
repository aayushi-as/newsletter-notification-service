package com.project.newsletter.controller;

import com.project.newsletter.model.User;
import com.project.newsletter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/{userId}/subscribe/{categoryId}")
    public ResponseEntity<?> subscribe(@PathVariable Long userId, @PathVariable Long categoryId) throws Exception {
        Optional<User> user = userService.getUserById(userId);

        if (user.isEmpty())
            throw new UsernameNotFoundException("User with user id : " + userId + "does not exist!");
        else {
            log.info("{} subscribe to {}", userId, categoryId);
            userService.userSubscribeToCategory(user.get(), categoryId);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully subscribed");
        }
    }

    @PostMapping("/{userId}/unsubscribes/{categoryId}")
    public ResponseEntity<?> unsubscribe(@PathVariable Long userId, @PathVariable Long categoryId) throws Exception {
        Optional<User> user = userService.getUserById(userId);

        if (user.isEmpty())
            throw new UsernameNotFoundException("User with user id : " + userId + "does not exist!");
        else {
            log.info("{} unsubscribes to {}", userId, categoryId);
            boolean result = userService.userUnsubscribeToCategory(user.get(), categoryId);

            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            String message = "Failed to unsubscribe";

            if (result) {
                status = HttpStatus.OK;
                message = "Successfully unsubscribed";
            }
            return ResponseEntity.status(status).body(message);
        }
    }

}
