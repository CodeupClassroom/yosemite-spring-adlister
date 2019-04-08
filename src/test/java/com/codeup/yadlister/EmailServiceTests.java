package com.codeup.yadlister;

import com.codeup.yadlister.models.Ad;
import com.codeup.yadlister.services.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    public void testSendingEmail(){
        String subject = "Test email";
        String body = "Test content";
        Ad ad = new Ad();
        ad.setTitle("MacBook");
        ad.setDescription("like new");
        SimpleMailMessage smm = emailService.prepare(ad, subject, body);
        assertEquals(smm.getSubject(), subject);
        assertEquals(smm.getText(), body);
    }

}
