package com.sandwich.service.impl;

import com.sandwich.repository.ISandwichRepository;
import com.sandwich.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandwichService implements ISandwichService {

    @Autowired
    private ISandwichRepository iSandwichRepository;

    @Override
    public List<String> finAllSpice() {
        return this.iSandwichRepository.finAllSpice();
    }

    @Override
    public List<String> saveSpice(String[] condiment) {
        return this.iSandwichRepository.saveSpice(condiment);
    }
}
