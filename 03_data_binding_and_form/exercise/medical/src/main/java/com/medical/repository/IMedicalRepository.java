package com.medical.repository;

import com.medical.model.Person;

import java.util.List;

public interface IMedicalRepository {
    List<String> yearOfBirth();
    List<String> day();
    List<String> month();
    List<String> gender();
    List<String> country();
    List<String> travelInformation();
}
