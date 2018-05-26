package com.sweb.bestlunch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error2")
public class ErrorController {
    @GetMapping("/")
    public String getError(){
        return "error";
    }
}
