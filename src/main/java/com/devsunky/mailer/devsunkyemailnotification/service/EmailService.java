package com.devsunky.mailer.devsunkyemailnotification.service;

import com.devsunky.mailer.devsunkyemailnotification.model.EmailParameter;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailService {
    public void sendEmail(EmailParameter emailParameter)throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        //props.put("mail.smtp.port", "587");
        props.put("mail.smtp.username", "sunkydevelopa@gmail.com");
        props.put("mail.smtp.password", "omoniyi100");
        props.put("mail.smtp.from.email", "sunkydevelopa@gmail.com");
        props.put("mail.smtp.transport.protocol", "smtp");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailParameter.getFromEmailAddress(), emailParameter.getFromEmailAddressPassword());
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(emailParameter.getFromEmailAddress(), false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailParameter.getToEmailAddress()));
        msg.setSubject(emailParameter.getSubject());
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(emailParameter.getContent(), "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        if(emailParameter.getFileUploadPath() == null){
            msg.setContent(multipart);
            Transport.send(msg);
        }else{
            String uploadDirectory = FilenameUtils.normalize(emailParameter.getFileUploadPath());
            Resource resource = new FileSystemResource(uploadDirectory);
            attachPart.attachFile(resource.getFile());
            multipart.addBodyPart(attachPart);
            msg.setContent(multipart);
            Transport.send(msg);
        }


    }
}
