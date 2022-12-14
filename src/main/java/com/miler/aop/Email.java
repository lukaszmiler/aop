package com.miler.aop;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Email// implements EmailService
{

    private JavaMailSender emailSender = new AspectFilms().getJavaMailSender();;

    //@Autowired
//    public Email(JavaMailSender emailSender) {
//        this.emailSender = new AspectFilms().getJavaMailSender();
//    }

    public void sendSimpleMessageByMe(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}
