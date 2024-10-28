package com.project.newsletter.service;

import com.project.newsletter.model.Category;
import com.project.newsletter.model.Newsletter;
import com.project.newsletter.repository.NewsletterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class NewsletterService {

    private final CategoryService categoryService;

    private final NewsletterRepository newsletterRepository;

    public NewsletterService(CategoryService categoryService, NewsletterRepository newsletterRepository) {
        this.categoryService = categoryService;
        this.newsletterRepository = newsletterRepository;
    }

    public Newsletter addNewsletter(String title, String description, String publishedBy, Long categoryId) throws Exception {
        Newsletter newsletter = new Newsletter();
        newsletter.setTitle(title);
        newsletter.setDescription(description);
        newsletter.setPublishedBy(publishedBy);
        newsletter.setCreatedAt(LocalDateTime.now());

        Optional<Category> category = categoryService.getCategoryById(categoryId);

        if (category.isEmpty()) {
            log.error("Category id provided in request does not exist!");
            throw new Exception("Cannot add newsletter as given category does not exist");
        }

        newsletter.setCategory(category.get());

        return newsletterRepository.save(newsletter);
    }
}
