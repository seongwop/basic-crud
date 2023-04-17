package com.example.postcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PostCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostCrudApplication.class, args);
    }

}
