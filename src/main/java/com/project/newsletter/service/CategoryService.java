package com.project.newsletter.service;

import com.project.newsletter.model.Category;
import com.project.newsletter.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        log.info("getAllCategories Service >>");
        return categoryRepository.findAll();
    }

    public Category addCategory(Category category) {
        if (category != null) {
            log.info("addCategory >> {}", category);
            return categoryRepository.save(category);
        }
        else {
            log.error("addCategory >> null category");
            return null;
        }
    }

    public Optional<Category> getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    public Optional<Category> getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }
}
