package com.appliti.homer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(scanBasePackages = "com.appliti.homer")
@EnableJpaRepositories(basePackages = "com.appliti.homer")
@EnableWebSecurity
public class HomerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(HomerApplication.class, args);
    }
}
