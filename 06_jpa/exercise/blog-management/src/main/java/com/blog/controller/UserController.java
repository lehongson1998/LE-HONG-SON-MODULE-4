package com.blog.controller;

import com.blog.model.User;
import com.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
//    @Autowired
//    private IUserService iUserService;
//
//    @GetMapping("/")
//    public String formLogin(Model model){
//        model.addAttribute("users", new User());
//        return "/user/login";
//    }
//
//    @PostMapping("/login")
//    public String login(@ModelAttribute User user, Model model){
//        User user1 = iUserService.login(user);
//        if (user1 != null){
//            model.addAttribute("msg", "login success");
//            return "/blog/list";
//        }else {
//            return "/user/login";
//        }
//    }
}
