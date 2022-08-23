package com.blog.repository.impl;

import com.blog.model.User;
import com.blog.repository.IUserRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
public class UserRepository implements IUserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    public User login(User user) {
        String sql = "CALL login(:account, :password)";
        Query query = em.createNativeQuery(sql);
        query.setParameter("account", user.getAccount());
        query.setParameter("password", user.getPassword());
        try {
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
