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
    @RequestMapping("/page1")
    public ModelAndView page1() {
        return new ModelAndView("page1");
    }

    @RequestMapping("/_Layout")
    public ModelAndView _Layout() {
        return new ModelAndView("_Layout");
    }


}



