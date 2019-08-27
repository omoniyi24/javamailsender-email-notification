package com.devsunky.mailer.devsunkyemailnotification.controller;

import com.devsunky.mailer.devsunkyemailnotification.model.EmailParameter;
import com.devsunky.mailer.devsunkyemailnotification.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @RequestMapping(value = {"/sendemail"}, method = RequestMethod.POST)
    public String sendEmail(@RequestBody EmailParameter emailParameter) throws IOException, MessagingException {

        emailService.sendEmail(emailParameter);
        return "Email sent successfully";
    }
}
