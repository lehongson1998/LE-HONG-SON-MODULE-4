package com.music_library.repository.impl;

import com.music_library.model.Music;
import com.music_library.repository.IMusicRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {
    private final String SELECT = "select m from Music m";

    @Override
    public void createNewMusic(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public Music findById(int id) {
        Music music = BaseRepository.entityManager.find(Music.class, id);
        return music;
    }

    @Override
    public List<Music> list() {
        TypedQuery<Music> typedQuery = BaseRepository.entityManager.createQuery(SELECT, Music.class);
        return typedQuery.getResultList();
    }

    @Override
    public void updateMusic(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public void deleteMusic(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Music music = BaseRepository.entityManager.find(Music.class, id);
        BaseRepository.entityManager.remove(music);
        entityTransaction.commit();
    }
}
