package com.blog.repository;

import com.blog.model.User;

public interface IUserRepository {
    void saveUser(User user);

    User login(User user);
}
