package org.example.lessonsPack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String indexGet(){
        return "index";
    }
}
