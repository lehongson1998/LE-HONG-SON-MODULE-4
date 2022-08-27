package com.case_study.repository;

import com.case_study.model.Customer;
import com.case_study.model.TypeCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findAllByNameContainingAndTypeCustomer_TypeNameCustomerContaining(String name, String typeCustomer, Pageable pageable);
}
