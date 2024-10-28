package com.project.newsletter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Newsletter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please provide title")
    private String title;

    @NotBlank(message = "Please provide description")
    private String description;

    @NotBlank(message = "Please provide publisher name")
    private String publishedBy;

    @JsonIgnore
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="categoryId", nullable=false)
    @JsonIgnore
    private Category category;
}
