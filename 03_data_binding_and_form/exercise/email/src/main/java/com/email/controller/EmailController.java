package com.email.controller;

import com.email.model.Email;
import com.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {

    @Autowired
    private IEmailService iEmailService;
    @GetMapping("/")
    public String showCreateEmail(Model model){
        model.addAttribute("languages", this.iEmailService.languages());
        model.addAttribute("pageSize", this.iEmailService.pageSize());
        model.addAttribute("email", this.iEmailService.display());
        return "email/update";
    }

    @PostMapping("/update")
    public String boxEmailView(@ModelAttribute Email email, Model model){
        this.iEmailService.save(email);
        model.addAttribute("boxEmail", this.iEmailService.display());
        return "email/info";
    }
}
