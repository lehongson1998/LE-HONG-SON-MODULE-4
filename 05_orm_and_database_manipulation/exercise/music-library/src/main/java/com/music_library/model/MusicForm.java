package com.music_library.model;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private int id;
    private String musicName;
    private String singleName;
    private MultipartFile musicLink;

    public MusicForm() {
    }

    public MusicForm(String musicName, String singleName, MultipartFile musicLink) {
        this.musicName = musicName;
        this.singleName = singleName;
        this.musicLink = musicLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSingleName() {
        return singleName;
    }

    public void setSingleName(String singleName) {
        this.singleName = singleName;
    }

    public MultipartFile getMusicLink() {
        return musicLink;
    }

    public void setMusicLink(MultipartFile musicLink) {
        this.musicLink = musicLink;
    }
}
