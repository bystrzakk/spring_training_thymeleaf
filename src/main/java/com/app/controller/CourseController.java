package com.app.controller;


import com.app.controller.model.DocumentDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class CourseController {

    @GetMapping(value = "/")
    public String init(Model model) {
        model.addAttribute("homeTitle", "Testowa aplikacja");
        model.addAttribute("newDocument", new DocumentDto());
        return "home";
    }

    @PostMapping(value = "/processForm")
    public String processForm(@RequestParam(name = "foo", required = false) String foo, Model model) {
        System.out.println(foo);
        model.addAttribute("fooText", foo);
        return "home";
    }

    @PostMapping(value = "/addDocument")
    public String addDocument(@ModelAttribute("newDocument") DocumentDto documentDto) {

        return "home";
    }

    @GetMapping(value = "/getAll")
    public ModelAndView getAll(ModelAndView modelAndView) {
        List<String> randomElementList = Arrays.asList("Tes1", "Test2", "Test3");
        modelAndView.setViewName("home");
        modelAndView.addObject("randomList", randomElementList);
        return modelAndView;
    }
}