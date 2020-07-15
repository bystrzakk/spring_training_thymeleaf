package com.app.controller;


import com.app.dto.CourseDto;
import com.app.model.Course;
import com.app.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class CourseController {

    private final CourseService courseService;
    private static final int PAGE_SIZE = 4;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public String welcomePage(Model model) {
        model.addAttribute("homeTitle", "Text message");

        return "home";
    }

    @GetMapping("/list")
    public ModelAndView courseList(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page) {
        ModelAndView model = new ModelAndView();
        Page<CourseDto> courseList = courseService.getAllCourse(page, PAGE_SIZE);
        model.addObject("courseLists", courseList);
        model.setViewName("course_list");
        return model;
    }

    @GetMapping("/addCoursePage")
    public ModelAndView addCoursePage(ModelAndView modelAndView, Model model, HttpSession session) {
        Course course = new Course();
        model.addAttribute("addCourseText", "Dodaj nowy kurs");
        //session.setAttribute("addCourseText", "Dodaj nowy kurs");
        modelAndView.addObject("courseForm", course);
        modelAndView.setViewName("form");
        return modelAndView;
    }

    @PostMapping("/addCourse")
    public String addCourse(@ModelAttribute("courseForm") @Valid CourseDto courseDto,
                            BindingResult validation) {
        if (validation.hasErrors()) {
            return "form";
        }
        courseService.saveCourse(courseDto);
        return "redirect:/list";
    }

    @GetMapping("/deleteCourse/{c_id}")
    public ModelAndView deleteCourse(@PathVariable("c_id") int id) {
        courseService.deleteCourse(id);
        return new ModelAndView("redirect:/list");
    }

    @GetMapping("/updateCourse/{c_id}")
    public ModelAndView updateCourse(@PathVariable("c_id") int id) {
        ModelAndView model = new ModelAndView();
        CourseDto course = courseService.getCourseById(id);
        model.addObject("courseForm", course);
        model.setViewName("form");

        return model;
    }

}
