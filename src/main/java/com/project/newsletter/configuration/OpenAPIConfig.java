package com.project.newsletter.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI newsletterProjectAPI() {
        return new OpenAPI()
                .info(new Info().title("Newsletter Notification Service API")
                        .description("Rest API documentation")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Source Code available on github")
                        .url("https://github.com/aayushi-as"));
    }
}

