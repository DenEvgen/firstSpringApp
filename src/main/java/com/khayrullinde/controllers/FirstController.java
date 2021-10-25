package com.khayrullinde.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @GetMapping("/home")
    public String homePage(@RequestParam(value = "name", required = false) String name,Model model){
        model.addAttribute("startMessage", "Hi, " + name);
        return "first/home";
    }

    @GetMapping("/goodbye")
    public String byePage(){
        return "first/goodbye";
    }
}
