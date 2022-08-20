package com.music_library.controller;

import com.music_library.model.Music;
import com.music_library.model.MusicForm;
import com.music_library.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/song")
@PropertySource("classpath:upload-file.properties")
public class MusicController {
    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private IMusicService iMusicService;

    @GetMapping("")
    public String musicList(Model model){
        List<Music> musicList = this.iMusicService.list();
        model.addAttribute("musicList", musicList);
        return "/music/list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/music/create");
        modelAndView.addObject("musicForm", new MusicForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute MusicForm musicForm) {
        MultipartFile multipartFile = musicForm.getMusicLink();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getMusicLink().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Music music = new Music(musicForm.getMusicName(), musicForm.getSingleName(), fileName);
        iMusicService.createNewMusic(music);
        ModelAndView modelAndView = new ModelAndView("/music/create");
        modelAndView.addObject("musicForm", musicForm);
        modelAndView.addObject("message", "Created new song successfully !");
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteSong(@RequestParam int id){
        this.iMusicService.deleteMusic(id);
        ModelAndView modelAndView = new ModelAndView("/music/list");
        modelAndView.addObject("musicList", this.iMusicService.list());
        return modelAndView;
    }

    @GetMapping("/showEdit")
    public String showFormEdit(@RequestParam int id, Model model){
        model.addAttribute("music", this.iMusicService.findById(id));
        return "/music/edit";
    }

    @PostMapping("/edit")
    public String editMusic(@ModelAttribute Music music ,Model model){
        this.iMusicService.updateMusic(music);
        List<Music> musicList = this.iMusicService.list();
        model.addAttribute("musicList", musicList);
        return "/music/list";
    }

}
