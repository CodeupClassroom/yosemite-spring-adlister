package com.codeup.yadlister.quotes;

import com.codeup.yadlister.quotes.Quote;
import com.codeup.yadlister.quotes.QuotesList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuotesController {

    @GetMapping("/quotes")
    public String getQuotes(Model model) {
        List<Quote> quotes = QuotesList.all();
        model.addAttribute("quotes", quotes);
        return "quotes/index";
    }

    @GetMapping("/quotes/random")
    public String random(Model model){
        Quote quote = QuotesList.random();
        model.addAttribute("quote", quote);
        return "quotes/show";
    }

    @GetMapping("/quotes/{id}")
    public String show(@PathVariable long id, Model model){
        Quote quote = QuotesList.findOne(id);
        model.addAttribute("quote", quote);
        return "quotes/show";
    }
}
