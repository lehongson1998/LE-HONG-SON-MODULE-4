package com.medical.service.impl;

import com.medical.model.Person;
import com.medical.repository.IMedicalRepository;
import com.medical.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicalService implements IMedicalService {
    @Autowired
    private IMedicalRepository iMedicalRepository;

    @Override
    public List<String> yearOfBirth() {
        return this.iMedicalRepository.yearOfBirth();
    }

    @Override
    public List<String> day() {
        return this.iMedicalRepository.day();
    }

    @Override
    public List<String> month() {
        return this.iMedicalRepository.month();
    }

    @Override
    public List<String> gender() {
        return this.iMedicalRepository.gender();
    }

    @Override
    public List<String> country() {
        return this.iMedicalRepository.country();
    }

    @Override
    public List<String> travelInformation() {
        return this.iMedicalRepository.travelInformation();
    }

    @Override
    public void save(Person person) {
        this.iMedicalRepository.save(person);
    }

    @Override
    public List<Person> display() {
        return this.iMedicalRepository.display();
    }

    @Override
    public void edit(Person person) {
        this.iMedicalRepository.edit(person);
    }

    @Override
    public Person findByIdCard(String idCard) {
        return this.iMedicalRepository.findByIdCard(idCard);
    }
}
