package com.medical.controller;

import com.medical.model.Person;
import com.medical.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/add")
    public String createMedical(@ModelAttribute("person") Person person, Model model){
        this.iMedicalService.save(person);
        model.addAttribute("personMedical", this.iMedicalService.display());
        return "medical/medical_show";
    }

    @GetMapping("/view")
    public String displayMedical(Model model){
        model.addAttribute("personMedical", this.iMedicalService.display());
        return "medical/medical_show";
    }

    @GetMapping("/form")
    public String ShowFormEdit(@RequestParam String idCard, Model model){
        model.addAttribute("person", this.iMedicalService.findByIdCard(idCard));
        model.addAttribute("year", this.iMedicalService.yearOfBirth());
        model.addAttribute("day", this.iMedicalService.day());
        model.addAttribute("month", this.iMedicalService.month());
        model.addAttribute("gender", this.iMedicalService.gender());
        model.addAttribute("country", this.iMedicalService.country());
        model.addAttribute("travel", this.iMedicalService.travelInformation());
        return "medical/form-edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("person") Person person, Model model){
        this.iMedicalService.edit(person);
        model.addAttribute("personMedical", this.iMedicalService.display());
        return "medical/medical_show";
    }
}
