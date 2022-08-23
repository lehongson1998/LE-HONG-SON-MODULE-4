package com.blog.service;

import com.blog.model.User;

public interface IUserService {
    void saveUser(User user);

    User login(User user);
}
