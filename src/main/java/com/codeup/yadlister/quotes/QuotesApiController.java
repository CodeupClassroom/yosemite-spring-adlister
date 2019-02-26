package com.codeup.yadlister.quotes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuotesApiController {

    @GetMapping("/api/quotes/")
    public List<Quote> all() {
        return QuotesList.all();
    }

    @GetMapping("/api/quotes/random")
    public Quote random() {
        return QuotesList.random();
    }

    @GetMapping("/api/quotes/{id}")
    public Quote show(@PathVariable long id) {
        return QuotesList.findOne(id);
    }
}
