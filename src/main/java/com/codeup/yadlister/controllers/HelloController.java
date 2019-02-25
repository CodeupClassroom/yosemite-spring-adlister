package com.codeup.yadlister.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("/hello/{name}/{age}")
    @ResponseBody
    public String hello(@PathVariable String name, @PathVariable int age){
        return "Hello from " + name + " age: " + age;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello from Spring";
    }

    @PostMapping("/hello")
    @ResponseBody
    public String getPassword(@RequestParam(name = "password") String pass){
        return "123" + pass + "ASDASD";
    }

    @GetMapping("/test.json")
    @ResponseBody
    public List<String> getList(){
        List<String> names = new ArrayList<>();
        names.add("Fer");
        names.add("Sophie");
        names.add("Ryan");
        return names;
    }

}