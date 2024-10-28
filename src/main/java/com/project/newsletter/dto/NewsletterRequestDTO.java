package com.project.newsletter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class NewsletterRequestDTO implements Serializable {
    @NotBlank(message = "Please provide title")
    private String title;

    @NotBlank(message = "Please provide description")
    private String description;

    @NotBlank(message = "Please provide publisher name")
    private String publishedBy;

    @NotNull(message = "Please provide category id")
    private Long categoryId;
}
