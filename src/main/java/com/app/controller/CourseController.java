package com.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {

    @GetMapping(value = "/")
    public String init(Model model) {
        model.addAttribute("homeTitle", "Testowa aplikacja");
        return "home";
    }

    @PostMapping(value = "/processForm")
    public String processForm(@RequestParam(name = "foo", required = false) String foo, Model model) {
        System.out.println(foo);
        model.addAttribute("fooText", foo);
        return "home";
    }
}