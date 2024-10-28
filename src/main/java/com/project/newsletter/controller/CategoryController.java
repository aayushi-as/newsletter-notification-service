package com.project.newsletter.controller;

import com.project.newsletter.exception.DuplicateCategoryException;
import com.project.newsletter.model.Category;
import com.project.newsletter.service.CategoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllCategories() {
        log.info("getAllCategories Controller >>");
        List<Category> categoryList = categoryService.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categoryList);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEvent(@Valid @RequestBody Category category) {
        log.info("addCategory >>");

        Optional<Category> existingEvent = categoryService.getCategoryByName(category.getName());

        if (existingEvent.isPresent()) {
            throw new DuplicateCategoryException("Category already exists");
        }

        Category savedCategory = categoryService.addCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }
}
