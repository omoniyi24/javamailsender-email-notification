package com.devsunky.mailer.devsunkyemailnotification.model;

import lombok.Data;

import javax.mail.Multipart;
import java.io.File;

@Data
public class EmailParameter {

    private String fromEmailAddress;

    private String fromEmailAddressPassword;

    private String toEmailAddress;

    private String subject;

    private String content;

    private File fileUploadPath;


}
