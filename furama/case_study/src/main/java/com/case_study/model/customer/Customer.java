package com.case_study.model.customer;

import com.case_study.model.Person;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class Customer extends Person {
    private boolean gender;
    @ManyToOne
    @JoinColumn(name = "type_customer_id", referencedColumnName = "typeCustomerId", nullable = false)
    private TypeCustomer typeCustomer;

    public Customer() {
    }

    public Customer(Long id, String name, LocalDate dateOfBirth, String idCard, String phoneNumber, String email, String address, boolean gender, TypeCustomer typeCustomer) {
        super(id, name, dateOfBirth, idCard, phoneNumber, email, address);
        this.gender = gender;
        this.typeCustomer = typeCustomer;
    }

    public Customer(String name, LocalDate dateOfBirth, String idCard, String phoneNumber, String email, String address, boolean gender, TypeCustomer typeCustomer) {
        super(name, dateOfBirth, idCard, phoneNumber, email, address);
        this.gender = gender;
        this.typeCustomer = typeCustomer;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }
}
