package com.codeup.yadlister.controllers;

import com.codeup.yadlister.models.Ad;
import com.codeup.yadlister.models.Post;
import com.codeup.yadlister.repositories.AdRepository;
import com.codeup.yadlister.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdController {
    private final AdRepository adDao;

    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }

    @Autowired
    private EmailService emailService;

    // load the form for new blog posts
    @GetMapping("/ads/create")
    public String showForm(){
        return "ads/create";
    }

    // save the new post to the database
    @PostMapping("/ads/create")
    public String create(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description") String description
    ){

        Ad ad = new Ad(title, description);

        Ad savedAd = adDao.save(ad);

        emailService.prepareAndSend(savedAd, "Ad created successfully", "The ad was created with the id " + savedAd.getId());


        return "redirect:/ads";

    }
}
