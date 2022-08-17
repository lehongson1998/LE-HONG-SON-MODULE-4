package com.email.service.impl;

import com.email.model.Email;
import com.email.repository.IEmailRepository;
import com.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository emailRepository;

    @Override
    public List<String> languages() {
        return this.emailRepository.languages();
    }

    @Override
    public List<Integer> pageSize() {
        return this.emailRepository.pageSize();
    }

    @Override
    public Email display() {
        return this.emailRepository.display();
    }

    @Override
    public void save(Email emailBox) {
        this.emailRepository.save(emailBox);
    }
}
