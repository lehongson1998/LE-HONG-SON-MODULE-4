package com.email.service;

import com.email.model.Email;

import java.util.List;

public interface IEmailService {
    List<String> languages();
    List<Integer> pageSize();
    public Email display();
    void save(Email email);
}
