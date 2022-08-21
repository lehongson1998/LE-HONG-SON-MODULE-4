package com.music_library.repository;

import com.music_library.model.Music;

import java.util.List;

public interface IMusicRepository {
    void createNewMusic(Music music);

    List<Music> list();

    void updateMusic(int id, Music music);

    void deleteMusic(int id);
}
