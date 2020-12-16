package org.example.lessonsPack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = {"/", ""})
    public String indexGet(){
        System.out.println("request for root job");
        return "index";
    }

    @RequestMapping(value = "/login")
    public String loginPage(){
        System.out.println("request for login job");
        return "login";
    }
}
