package com.codeup.yadlister.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home"; // relative path to src/resources/templates
    }

    @GetMapping("/dice")
    public String showRolls() {
        return "dice/show-rolls";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        String message;

        int random = (int) Math.ceil(Math.random() * 6);

        if(random == guess) {
            message = "You guessed the random number!";
        } else {
            message = "The numbers do not match.";
        }

        model.addAttribute("random", random);
        model.addAttribute("guess", guess);
        model.addAttribute("message", message);

        return "dice/roll-dice";
    }
}
