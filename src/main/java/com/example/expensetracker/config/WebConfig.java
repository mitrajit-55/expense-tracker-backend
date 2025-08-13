package com.expensetracker.config; // <-- Change this to your actual package

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // No backslash before stars!
                        // Use your actual deployed frontend URL
                        .allowedOrigins("https://expense-tracker-frontend-vlul.onrender.com")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*") // No escaping star
                        .allowCredentials(true) // Allow cookies/auth if needed
                        .maxAge(3600); // Cache preflight for 1 hour
            }
        };
    }
}

