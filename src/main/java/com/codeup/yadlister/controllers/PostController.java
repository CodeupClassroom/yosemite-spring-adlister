package com.codeup.yadlister.controllers;

import com.codeup.yadlister.models.Post;
import com.codeup.yadlister.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    // show all posts
    @GetMapping("/posts")
    public String all(Model model){

        Iterable<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);

        return "posts/index";
    }

    // show a specific post
    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model){

        Post post = postDao.findOne(id);

        model.addAttribute("post", post);

        return "posts/show";
    }

    // load the form for new blog posts
    @GetMapping("/posts/create")
    public String showForm(){
        return "posts/create";
    }

    // save the new post to the database
    @PostMapping("/posts/create")
    public String create(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
            ){

        Post post = new Post(title, body);

        postDao.save(post);

        return "redirect:/posts";

    }

    // Bring up a post object in a form to edit it.
    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";

    }

    // Save the edited post object
    @PostMapping("/posts/{id}/edit")
    public String update(
            @PathVariable long id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body,
            Model model) {

        System.out.println("inside the update method now...");

        Post post = postDao.findOne(id);
        post.setTitle(title);
        post.setBody(body);

        postDao.save(post);

        return "redirect:/posts/" + id;
    }


    // delete a specific post
    @PostMapping("/posts/delete")
    public String delete(@RequestParam(name = "id") long id) {
        Post post = postDao.findOne(id);
        postDao.delete(post);

        return "redirect:/posts";
    }

    // show a random post
    @GetMapping("/posts/random")
    public String random(Model model) {

        Post post = postDao.getRandom();
        model.addAttribute("post", post);

        return "posts/show";
    }

}
