 package com.singup_form.controller;

import com.singup_form.dto.UserDto;
import com.singup_form.model.User;
import com.singup_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.time.LocalDate;

 @Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String formCreateUser(Model model){
        model.addAttribute("userDto", new UserDto());
        return "user/create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("userDto") @Valid UserDto userDto,
                             BindingResult bindingResult,
                             Model model){
        new UserDto().validate(userDto, bindingResult);
        model.addAttribute("userDto",userDto);
        if (bindingResult.hasErrors()){
            return "user/create";
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        this.iUserService.createUser(user);
        model.addAttribute("msg", "singUp success");
        return "user/result";
    }

}
