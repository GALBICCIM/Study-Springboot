package com.hansei.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello-mvc")
    public String hello(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    
    @GetMapping("hello")
    @ResponseBody
    public String helloMvc(@RequestParam(value = "name", required = false) String name) {
        return "Hello " + name;
    }
}
