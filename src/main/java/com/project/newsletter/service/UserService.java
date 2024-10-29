package com.project.newsletter.service;

import com.project.newsletter.model.Category;
import com.project.newsletter.model.User;
import com.project.newsletter.repository.CategoryRepository;
import com.project.newsletter.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    private final CategoryRepository categoryRepository;

    public UserService(UserRepository userRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    public void addUser(User user) {
        if (user != null) {
            log.info("addUser >> {}", user);
            userRepository.save(user);
        }
        else {
            log.error("addUser >> user is null");
        }
    }

    public Optional<User> getUser(String emailId) {
        return userRepository.findByEmailId(emailId);
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User userSubscribeToCategory(User user, Long categoryId) throws Exception {
        Optional<Category> category = categoryRepository.findById(categoryId);

        if (category.isEmpty())
            throw new Exception("Category not found!");

        else {
            Set<Category> categories = user.getCategories();
            categories.add(category.get());
            user.setCategories(categories);
            return userRepository.save(user);
        }
    }

    public boolean userUnsubscribeToCategory(User user, Long categoryId) throws Exception {
        boolean result = false;

        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isEmpty())
            throw new Exception("Category not found!");
        
        else {
            Set<Category> categories = user.getCategories();
            categories.remove(category.get());
            user.setCategories(categories);
            userRepository.save(user);

            result = true;

        }
        
        return result;
    }

    public List<User> getUserByCategoryId(Long newsletterCategory) {
        return userRepository.findByCategoriesId(newsletterCategory);
    }
}
