package com.music_library.model;

import javax.persistence.*;

@Entity
@Table(name = "music_info")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "music_name")
    private String musicName;
    @Column(name = "single_name")
    private String singleName;
    @Column(name = "music_link")
    private String musicLink;

    public Music() {
    }

    public Music(String musicName, String singleName, String musicLink) {
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

    public String getMusicLink() {
        return musicLink;
    }

    public void setMusicLink(String musicLink) {
        this.musicLink = musicLink;
    }
}
