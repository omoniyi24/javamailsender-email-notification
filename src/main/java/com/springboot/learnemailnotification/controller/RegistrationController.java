package com.springboot.learnemailnotification.controller;


import com.springboot.learnemailnotification.service.MailNotificationService;
import com.springboot.learnemailnotification.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class RegistrationController {

    @Autowired
    private MailNotificationService mailNotificationService;

    @RequestMapping("/signup")
    public String signUp(){
        return "Please signup for our service";
    }

    @RequestMapping("/signup-sucess")
    public String signUpSucess(){

        //create a user
        User user = new User();
        user.setFirstname("Akindele");
        user.setLastname("Oyindamola");
        user.setEmailAddress("*********@gmail.com");

        //send notification
        try{
            mailNotificationService.sendNotification(user);
        }catch (MailException e){
            e.printStackTrace();
        }

        return "Thanks for registering with us";
    }


}
