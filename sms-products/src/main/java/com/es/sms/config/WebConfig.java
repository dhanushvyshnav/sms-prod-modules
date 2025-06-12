package com.es.sms.config;

import com.es.sms.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * Web Configuration class that handles CORS (Cross-Origin Resource Sharing) settings
 * and interceptor configurations for the application.
 *
 * CORS Configuration:
 * - Allows requests from http://localhost:3000
 * - Only permits GET methods
 * - Specifically allows only X-Auth-Token header
 * - Applies to all endpoints (**)
 *
 * Interceptor Configuration:
 * - Registers AuthInterceptor for authentication checks
 * - Applies to paths starting with:
 *   - /product/**
 *   - /module/**
 */
@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET")
                .allowedHeaders("X-Auth-Token");
    }
    @Autowired
    private AuthInterceptor authInterceptor ;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/product/**").addPathPatterns("/module/**");
    }
}
