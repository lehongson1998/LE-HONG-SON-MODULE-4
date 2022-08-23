package com.blog.service.impl;

import com.blog.model.User;
import com.blog.repository.IUserRepository;
import com.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void saveUser(User user) {
        iUserRepository.saveUser(user);
    }

    @Override
    public User login(User user) {
        return iUserRepository.login(user);
    }
}
