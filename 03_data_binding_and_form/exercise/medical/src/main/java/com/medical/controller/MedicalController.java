package com.medical.controller;

import com.medical.model.Person;
import com.medical.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalController {

    @Autowired
    private IMedicalService iMedicalService;

    @GetMapping("/")
    public String ShowForm(Model model){
        model.addAttribute("person", new Person());
        model.addAttribute("year", this.iMedicalService.yearOfBirth());
        model.addAttribute("day", this.iMedicalService.day());
        model.addAttribute("month", this.iMedicalService.month());
        model.addAttribute("gender", this.iMedicalService.gender());
        model.addAttribute("country", this.iMedicalService.country());
        model.addAttribute("travel", this.iMedicalService.travelInformation());
        return "medical/show_form";
    }

    @PostMapping(value = "/add")
    public String createMedical(@ModelAttribute("person") Person person, Model model){
        model.addAttribute("personMedical", person);
        return "medical/medical_show";
    }
}
