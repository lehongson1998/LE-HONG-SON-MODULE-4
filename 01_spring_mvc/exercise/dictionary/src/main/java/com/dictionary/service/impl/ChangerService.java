package com.dictionary.service.impl;

import com.dictionary.repository.IChangerRepository;
import com.dictionary.service.IChangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangerService implements IChangerService {

    @Autowired
    IChangerRepository changerRepository;

    @Override
    public String changer(String eng) {
        return this.changerRepository.changer(eng);
    }
}
