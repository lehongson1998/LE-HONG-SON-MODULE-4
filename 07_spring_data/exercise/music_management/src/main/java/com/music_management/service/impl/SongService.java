package com.music_management.service.impl;

import com.music_management.model.Song;
import com.music_management.repository.ISongRepository;
import com.music_management.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public Page<Song> finAll(String songName, String categoryName, Pageable pageable) {
        return iSongRepository.findAllBySongNameContainingAndCategoryContaining(songName, categoryName, pageable);
    }

    @Override
    public void saveSong(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Song findById(Long id) {
        return iSongRepository.findById(id).orElse(null);
    }
}
