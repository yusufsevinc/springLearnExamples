package com.yusufsevinc.springsecurity_1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @RequestMapping("/user")
    public String userLogin(){
        return "user login succesfull";

    }
    @RequestMapping("/admin")
    public String adminLogin(){
        return "Admin login succesfull";
    }
}
