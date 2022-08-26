package com.music_management.model;

import javax.persistence.*;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "text")
    private String songName;
    @Column(columnDefinition = "text")
    private String singleName;
    @Column(columnDefinition = "text")
    private String category;

    public Song() {
    }

    public Song(Long id, String songName, String singleName, String category) {
        this.id = id;
        this.songName = songName;
        this.singleName = singleName;
        this.category = category;
    }

    public Song(String songName, String singleName, String category) {
        this.songName = songName;
        this.singleName = singleName;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSingleName() {
        return singleName;
    }

    public void setSingleName(String singleName) {
        this.singleName = singleName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
