package com.tech.admire.unify.UnifyBackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allows all paths to have CORS
                .allowedOrigins("http://localhost:3000")  // Frontend URL (Change this to your frontend's origin)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")  // Allows all headers
                .allowCredentials(true)
                .maxAge(3600);
    }
}
