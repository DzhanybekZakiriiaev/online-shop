package com.example.inscope.service.email.impl;

import com.example.inscope.service.email.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultEmailService implements EmailService {
    @Value("${spring.mail.username}")
    private String mailFrom;

    private final JavaMailSender mailSender;

    @Override
    @Async
    public void send(String mailTo,String text) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(mailFrom);
            mailMessage.setTo(mailTo);
            mailMessage.setText(text);
            mailMessage.setSubject("УВЕДОМЛЕНИЕ YKY");

            mailSender.send(mailMessage);
        } catch (Exception ex) {
            log.error("Error in sending email. Msg: {}, Cause: {}", ex.getMessage(), ex.getCause());
        }
    }

    @Override
    @Async
    public void sendAdminMail(String text) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(mailFrom);
            mailMessage.setTo("djan.zakiriyaev@gmail.com");
            mailMessage.setText(text);
            mailMessage.setSubject("УВЕДОМЛЕНИЕ YKY");

            mailSender.send(mailMessage);
        } catch (Exception ex) {
            log.error("Error in sending email. Msg: {}, Cause: {}", ex.getMessage(), ex.getCause());
        }
    }
}
