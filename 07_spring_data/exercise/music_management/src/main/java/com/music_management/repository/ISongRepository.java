package com.music_management.repository;

import com.music_management.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Long> {
    Page<Song> findAllBySongNameContainingAndCategoryContaining(String songName, String categoryName, Pageable pageable);
}
