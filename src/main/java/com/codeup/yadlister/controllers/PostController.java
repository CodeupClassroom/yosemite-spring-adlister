package com.codeup.yadlister.controllers;

import com.codeup.yadlister.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String all(Model model){

        List<Post> posts = new ArrayList<>();
        posts.add(new Post(2, "CSS rocks", "Declarative programming languages are awesome"));
        posts.add(new Post(3, "JS is fun", "Programming is a way of thinking. Think in JS"));

        model.addAttribute("posts", posts);

        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model){

        Post post = new Post(id, "Hello World!", "This is my first post about JavaScript, yay!" );

        model.addAttribute("post", post);

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showForm(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@RequestParam(name = "title") String title){
        return "create a new post w/ title " + title;
    }
}
