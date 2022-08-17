package com.email.repository;

import com.email.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<String> languages();
    List<Integer> pageSize();
    void save(Email email);
    Email display();
}
