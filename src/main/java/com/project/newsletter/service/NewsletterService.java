package com.project.newsletter.service;

import com.project.newsletter.dto.DetailsAVRO;
import com.project.newsletter.dto.NewsletterObject;
import com.project.newsletter.dto.UserObject;
import com.project.newsletter.model.Category;
import com.project.newsletter.model.Newsletter;
import com.project.newsletter.model.User;
import com.project.newsletter.repository.NewsletterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class NewsletterService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private NewsletterRepository newsletterRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private KafkaProducer kafkaProducer;

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
        log.info("addNewsletter >> newsletter saved!");

        return newsletterRepository.save(newsletter);
    }
    
    public Optional<Newsletter> getNewsletterById(Long id) {
        return newsletterRepository.findById(id);
    }

    public void sendBulkNotification(Newsletter newsletter) {
        Long newsletterCategory = newsletter.getCategory().getId();

        log.info("sendBulkNotification >> ");
        NewsletterObject newsletterObject = new NewsletterObject();
        newsletterObject.setTitle(newsletter.getTitle());
        newsletterObject.setDescription(newsletter.getDescription());
        newsletterObject.setPublishedBy(newsletter.getPublishedBy());
        newsletterObject.setCategory(newsletter.getCategory().getName());

        List<UserObject> userList = new ArrayList<>();
        List<User> usersSubscribedToCategory = userService.getUserByCategoryId(newsletterCategory);

        for (User user: usersSubscribedToCategory) {

            UserObject userObj = new UserObject();
            userObj.setName(user.getName());
            userObj.setEmail(user.getEmailId());

            userList.add(userObj);
        }

        DetailsAVRO details = new DetailsAVRO();
        details.setNewsletter(newsletterObject);
        details.setUsers(userList);

        log.info("DetailsAVRO ready to kafka producer >> ");

        kafkaProducer.send(details);
    }
}
