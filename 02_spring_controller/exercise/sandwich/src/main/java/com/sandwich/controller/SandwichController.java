package com.sandwich.controller;

import com.sandwich.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SandwichController {
    @Autowired
    private ISandwichService iSandwichService;

    @GetMapping("/")
    public String displaySpice(Model model) {
        model.addAttribute("spice", this.iSandwichService.finAllSpice());
        return "spice/list";
    }

    @PostMapping("/add")
    public String displaySelect(@RequestParam(required = false) String[] condiment, Model model) {
        if (condiment == null) {
            model.addAttribute("message", "Please choose seasoning");
        } else {
            model.addAttribute("select", this.iSandwichService.saveSpice(condiment));
        }
        model.addAttribute("spice", this.iSandwichService.finAllSpice());
        return "spice/list";
    }
}
