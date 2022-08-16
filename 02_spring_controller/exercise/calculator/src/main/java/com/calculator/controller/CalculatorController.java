package com.calculator.controller;

import com.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String home(){
        return "/index";
    }

    @PostMapping("/calculator")
    public String calculate(@RequestParam String number1,
                            @RequestParam String number2,
                            @RequestParam String operator,
                            Model model){
        try{
            model.addAttribute("result",
                    this.iCalculatorService.operator(
                            Double.parseDouble(number1),
                            Double.parseDouble(number2),
                            operator));
        }catch (NumberFormatException n){
            model.addAttribute("result","please enter number");
        }
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        return "/index";
    }
}
