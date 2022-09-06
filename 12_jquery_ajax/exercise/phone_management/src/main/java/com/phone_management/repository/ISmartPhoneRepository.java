package com.phone_management.repository;

import com.phone_management.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartPhoneRepository extends JpaRepository<SmartPhone, Long> {
}
