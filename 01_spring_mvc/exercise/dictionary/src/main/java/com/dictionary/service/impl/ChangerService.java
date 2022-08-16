package com.dictionary.service.impl;

import com.dictionary.repository.impl.ChangerRepository;
import com.dictionary.service.IChangerService;
import org.springframework.stereotype.Service;

@Service
public class ChangerService implements IChangerService {
    ChangerRepository changerRepository = new ChangerRepository();
    @Override
    public String changer(String eng) {
        return changerRepository.changer(eng);
    }
}
