package com.singup_form.service.impl;

import com.singup_form.model.User;
import com.singup_form.repository.IUserRepository;
import com.singup_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void createUser(User user) {
        iUserRepository.save(user);
    }
}
