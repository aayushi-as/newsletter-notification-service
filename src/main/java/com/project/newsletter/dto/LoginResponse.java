package com.project.newsletter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class LoginResponse implements Serializable {
    private String emailId;
    private String name;
    private String role;
}
