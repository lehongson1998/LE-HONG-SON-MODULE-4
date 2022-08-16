package com.dictionary.controller;

import com.dictionary.service.IChangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IChangerService iChangerService;

    @GetMapping(value = "/")
    public String getFormDictionary(){
        return "/dictionary";
    }

    @PostMapping("/vietnamesse")
    public String changerLanguage(@RequestParam String eng, Model model){
        String result = this.iChangerService.changer(eng);
        if (result != null){
            model.addAttribute("result", result);
        }else {
            model.addAttribute("error", "không tìm thấy");
        }
        return "/dictionary";
    }
}
