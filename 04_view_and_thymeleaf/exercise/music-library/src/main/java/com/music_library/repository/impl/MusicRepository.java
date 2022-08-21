package com.music_library.repository.impl;

import com.music_library.model.Music;
import com.music_library.repository.IMusicRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.hibernate.cfg.Configuration;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {
//    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    @Override
    public void createNewMusic(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public List<Music> list() {
        TypedQuery<Music> typedQuery = BaseRepository.entityManager.createQuery("select m from Music m", Music.class);
        return typedQuery.getResultList();
    }

    @Override
    public void updateMusic(int id, Music music) {
        String queryStr = "update Music m set m.musicName = :musicName, m.singleName = :singleName, m.musicLink = :musicLink where id = :id";
        Query query = BaseRepository.entityManager.createQuery(queryStr, Music.class);
        query.setParameter("musicName", music.getMusicName());
        query.setParameter("singleName", music.getSingleName());
        query.setParameter("musicLink", music.getMusicLink());
        query.setParameter("id", music.getId());
        query.executeUpdate();
    }

    @Override
    public void deleteMusic(int id) {
//        Session session = sessionFactory.openSession();
//        String queryStr = "delete from Music m where m.id = :idDelete";
//        Query query = session.createQuery(queryStr, Music.class);
//        query.setParameter("idDelete", id);
//        query.executeUpdate();
    }
}
