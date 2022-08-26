package com.music_management.service;

import com.music_management.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song> finAll(String songName, String categoryName, Pageable pageable);

    void saveSong(Song song);

    Song findById(Long id);
}
