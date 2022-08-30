package com.singup_form.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Customer extends Person{
    private boolean gender;

    public Customer(Long id, String name, boolean gender) {
        super(id, name);
        this.gender = gender;
    }

    public Customer(String name, boolean gender) {
        super(name);
        this.gender = gender;
    }

    public Customer() {
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
