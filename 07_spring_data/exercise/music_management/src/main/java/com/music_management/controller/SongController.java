package com.music_management.controller;

import com.music_management.dto.SongDto;
import com.music_management.model.Song;
import com.music_management.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class SongController {

    @Autowired
    private ISongService iSongService;

    @GetMapping("")
    public String formCreateSong(Model model){
        model.addAttribute("songDto", new SongDto());
        return "song/create";
    }

    @PostMapping("/create")
    public String createSong(@ModelAttribute @Valid SongDto songDto,
                             BindingResult bindingResult,
                             Model model){
        new SongDto().validate(songDto, bindingResult);
        model.addAttribute("songDto", songDto);
        if (bindingResult.hasErrors()){
            return "song/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        this.iSongService.saveSong(song);
        model.addAttribute("msg", "create success");
        return "song/result";
    }

    @GetMapping("/list")
    public String listSong(Model model,
                           @PageableDefault(size = 2) Pageable pageable,
                           @RequestParam Optional<String> songName,
                           @RequestParam Optional<String> category){
        String songName1 = songName.orElse("");
        String category1 = category.orElse("");
        Page<Song> song = iSongService.finAll(songName1, category1, pageable);
        model.addAttribute("song", song);
        model.addAttribute("songName1", songName1);
        model.addAttribute("category1", category1);
        return "song/list";
    }

    @GetMapping("/formEdit/{id}")
    public String formEdit(Model model, @PathVariable Long id){
//        Song songDto = iSongService.findById(id);
//        SongDto songDto = new SongDto();
//        BeanUtils.copyProperties(song, songDto);
        model.addAttribute("songDto", this.iSongService.findById(id));
        return "song/edit";
    }

    @PostMapping("/edit")
    public String editSong(@ModelAttribute @Valid SongDto songDto,
                             BindingResult bindingResult,
                             Model model){
        new SongDto().validate(songDto, bindingResult);
        model.addAttribute("songDto", songDto);
        if (bindingResult.hasErrors()){
            return "song/edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        this.iSongService.saveSong(song);
        model.addAttribute("msg", "edit success");
        return "song/result";
    }
}
