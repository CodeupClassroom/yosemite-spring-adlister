package com.codeup.yadlister.controllers;

import com.codeup.yadlister.models.*;
import com.codeup.yadlister.repositories.AdRepository;
import com.codeup.yadlister.repositories.Users;
import com.codeup.yadlister.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdController {
    private final AdRepository adDao;

    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }

    @Autowired
    private EmailService emailService;

    @Autowired
    private Users userDao;

    // load the form for new blog posts
    @GetMapping("/ads/create")
    public String showCreateForm(Model model) {
        model.addAttribute("ad", new Ad());
        return "ads/create";
    }

    // save the new post to the database
    @PostMapping("/ads/create")
    public String create(@ModelAttribute Ad ad){

        List<AdImage> imgs = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User userDB = userDao.findOne(sessionUser.getId());
        ad.setCategories(categories);
        ad.setImages(imgs);
        ad.setUser(userDB);
        Ad savedAd = adDao.save(ad);

        emailService.send(emailService.prepare(savedAd, "Ad created successfully", "The ad was created with the id " + savedAd.getId()));

        return "redirect:/ads";

    }
}
