package com.medical.service;

import com.medical.model.Person;

import java.util.List;

public interface IMedicalService {
    List<String> yearOfBirth();

    List<String> day();

    List<String> month();

    List<String> gender();

    List<String> country();

    List<String> travelInformation();

    void save(Person person);

    List<Person> display();


}
