package com.example.inscope;

import com.example.inscope.service.email.EmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

//TODO: add user controller, frontend(web controller) and user restrictions

@SpringBootApplication
@EnableAsync
public class InScopeApplication {

    public static void main(String[] args) {
        SpringApplication.run(InScopeApplication.class, args);
    }
}
