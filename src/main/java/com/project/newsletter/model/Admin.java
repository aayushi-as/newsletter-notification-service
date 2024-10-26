package com.project.newsletter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Admin {

    @Id
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email id is blank")
    @Email(message = "Enter valid email address")
    private String emailId;

    @NotBlank(message = "Please provide username")
    private String fullName;

    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
}
