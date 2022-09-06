package com.phone_management.service;

import com.phone_management.model.SmartPhone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISmartPhoneService {
    Page<SmartPhone> findAll(Pageable pageable);

    Optional<SmartPhone> findById(Long id);

    void save(SmartPhone smartPhone);

    void remove(Long id);

}
