package com.phone_management.service.impl;

import com.phone_management.model.SmartPhone;
import com.phone_management.repository.ISmartPhoneRepository;
import com.phone_management.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartPhoneService implements ISmartPhoneService {
    @Autowired
    private ISmartPhoneRepository smartPhoneRepository;
    @Override
    public Page<SmartPhone> findAll(Pageable pageable) {
        return smartPhoneRepository.findAll(pageable);
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public void save(SmartPhone smartPhone) {
        smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartPhoneRepository.delete(smartPhoneRepository.findById(id).orElse(null));
    }
}
