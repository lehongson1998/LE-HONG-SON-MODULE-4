package com.money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangerMoney {
    @GetMapping("/")
    public String getForm(){
        return "/result";
    }
    @GetMapping("/result")
    public String changerMoney(@RequestParam int usd, Model model){
        final int RATE = 23000;
        try {
            int vnd = usd * RATE;
            model.addAttribute("vnd", vnd);
        }catch (NumberFormatException n){
            model.addAttribute("vnd", "null");
        }
        return "/result";
    }
}
