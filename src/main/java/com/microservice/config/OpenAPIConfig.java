package com.microservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("User Microservice Email API")
                .version("1.0")
                .description("API for managing users and sending emails.")
                .termsOfService("https://example.com/terms")
                .contact(new Contact()
                    .name("Your Name")
                    .email("youremail@example.com")
                    .url("https://yourwebsite.com"))
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}