package com.money.controller;

import com.money.service.IChangerMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangerMoneyController {

    @Autowired
    private IChangerMoneyService moneyService;

    @GetMapping("/")
    public String getForm(){
        return "/result";
    }
    @GetMapping("/result")
    public String changerMoney(@RequestParam int usd, Model model){
        int vnd = moneyService.changerMoney(usd);
        model.addAttribute("vnd", vnd);
        return "/result";
    }
}
