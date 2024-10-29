package com.project.newsletter.controller;

import com.project.newsletter.dto.NewsletterRequestDTO;
import com.project.newsletter.model.Newsletter;
import com.project.newsletter.service.NewsletterService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/admin/newsletter")
public class NewsletterController {

    private final NewsletterService newsletterService;

    public NewsletterController(NewsletterService newsletterService) {
        this.newsletterService = newsletterService;
    }

    @PostMapping("/publish")
    public ResponseEntity<?> publishNewsletter(@Valid @RequestBody NewsletterRequestDTO requestDTO) throws Exception {
        log.info("publishNewsletter Controller >> ");
        Newsletter savedNewsletter = newsletterService.addNewsletter(
                requestDTO.getTitle(),
                requestDTO.getDescription(),
                requestDTO.getPublishedBy(),
                requestDTO.getCategoryId());

        return ResponseEntity.status(HttpStatus.CREATED).body(savedNewsletter);
    }

    @PostMapping("/{id}/notify")
    public ResponseEntity<?> sendEmailNotification(@PathVariable Long id) throws Exception {

        Optional<Newsletter> newsletter = newsletterService.getNewsletterById(id);

        if (newsletter.isEmpty())
            throw new Exception("Newsletter not found");

        else
            newsletterService.sendBulkNotification(newsletter.get());

        log.info("Notification sent from controller sendEmailNotification >>");
        return ResponseEntity.status(HttpStatus.OK).body("Notification sent");
    }
}
