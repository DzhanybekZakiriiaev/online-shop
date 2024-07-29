package com.example.inscope.service.email;

import org.springframework.scheduling.annotation.Async;

public interface EmailService {
    void send(String mailTo, String text);

    @Async
    void sendAdminMail(String text);
}
