package com.codeup.yadlister.services;

import com.codeup.yadlister.models.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from;

    public SimpleMailMessage prepare(Ad ad, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
//        msg.setTo(ad.getUser().getEmail());
        msg.setTo("user@mypage.com");
        msg.setSubject(subject);
        msg.setText(body);
        return msg;
    }

    public void send(SimpleMailMessage msg){
        try{
            this.emailSender.send(msg);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }

}
