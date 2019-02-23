package com.springboot.learnemailnotification.service;

import com.springboot.learnemailnotification.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailNotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public MailNotificationService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(User user) throws MailException{
        //send email
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmailAddress());
//        mailMessage.setFrom("***************@gmail.com");
        mailMessage.setSubject("OTP from SKBank");
        mailMessage.setText("Use 6123 as OTP");

        javaMailSender.send(mailMessage);

    }
}
