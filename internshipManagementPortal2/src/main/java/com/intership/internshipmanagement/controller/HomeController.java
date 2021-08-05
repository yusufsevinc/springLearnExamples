package com.intership.internshipmanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping()
public class HomeController {

    @RequestMapping("/")
    public ModelAndView defaultHome() {
        return new ModelAndView("home");

    }

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }
}