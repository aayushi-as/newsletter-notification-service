package com.project.newsletter.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginRequest implements Serializable {

    @Email(message = "Enter valid email address")
    private String emailId;

    @NotBlank(message = "Password is mandatory to login")
    private String password;
}
