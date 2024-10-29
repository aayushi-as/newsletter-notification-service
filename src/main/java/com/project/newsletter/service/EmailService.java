package com.project.newsletter.service;

import com.project.newsletter.dto.NewsletterObject;
import com.project.newsletter.dto.UserObject;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.List;

@Service
public class EmailService {

    private static final Logger log = LogManager.getLogger(EmailService.class);
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Value("${email.from}")
    private String emailFrom;

    public void sendBulkEmail(List<UserObject> users, NewsletterObject newsletter) throws MessagingException {

        log.info("Inside EmailService >> sendBulkEmail");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String subject = "Newsletter Update:";
        helper.setSubject(subject);
        helper.setFrom(emailFrom);

        Context context = new Context();
        context.setVariable("category", newsletter.getCategory());
        context.setVariable("title", newsletter.getTitle());
        context.setVariable("description", newsletter.getDescription());
        context.setVariable("publishedBy", newsletter.getPublishedBy());


        StringBuilder newsletterContent = new StringBuilder();

        for (UserObject user : users) {
            context.setVariable("name", user.getName());
            String html = templateEngine.process("newsletter", context);

            newsletterContent.append(html);

            helper.addBcc(user.getEmail().toString());
        }

        helper.setText(newsletterContent.toString(), true);

        log.info("Sending Email using smtp...");
        mailSender.send(message);
    }
}

