package com.codeup.yadlister.controllers;

import com.codeup.yadlister.repositories.AdRepository;

public class AdController {
    private final AdRepository adDao;

    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }
}
