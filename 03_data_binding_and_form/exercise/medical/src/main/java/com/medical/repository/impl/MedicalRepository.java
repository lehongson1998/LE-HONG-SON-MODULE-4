package com.medical.repository.impl;

import com.medical.model.Person;
import com.medical.repository.IMedicalRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MedicalRepository implements IMedicalRepository {
    private static List<String> genderList = new ArrayList<>();
    private static List<String> yearList = new ArrayList<>();
    private static List<String> dayList = new ArrayList<>();
    private static List<String> monthList = new ArrayList<>();
    private static List<String> countryList = new ArrayList<>();
    private static List<String> travelList = new ArrayList<>();
    private static List<Person> personList = new ArrayList<>();
    static {
        for (int i = 1922; i < 2022; i++) {
            yearList.add(String.valueOf(i));
        }
        for (int i = 1; i <= 31; i++) {
            dayList.add(String.valueOf(i));
        }
        for (int i = 1; i <= 12; i++) {
            monthList.add(String.valueOf(i));
        }
        genderList.add("Nam");
        genderList.add("Nữ");
        genderList.add("Khác");

        countryList.add("Việt Nam");
        countryList.add("Trung Quốc");
        countryList.add("Lào");
        countryList.add("Campuchia");
        countryList.add("Đài Loan");
        countryList.add("Nhật Bản");
        countryList.add("Hàn Quốc");

        travelList.add("Tàu bay");
        travelList.add("Tàu thuyền");
        travelList.add("Ô tô");
        travelList.add("Khác");
    }

    @Override
    public List<String> yearOfBirth() {
        return yearList;
    }

    @Override
    public List<String> day() {
        return dayList;
    }

    @Override
    public List<String> month() {
        return monthList;
    }

    @Override
    public List<String> gender() {
        return genderList;
    }

    @Override
    public List<String> country() {
        return countryList;
    }

    @Override
    public List<String> travelInformation() {
        return travelList;
    }

    @Override
    public void save(Person person) {
        personList.add(person);
    }

    @Override
    public List<Person> display() {
        return personList;
    }

    @Override
    public void edit(Person person) {
        for (int i = 0; i < personList.size(); i++) {
            if (person.getIdCard().equals(personList.get(i).getIdCard())){
                personList.get(i).setName(person.getName());
                personList.get(i).setDateOfBirth(person.getDateOfBirth());
                personList.get(i).setGender(person.getGender());
                personList.get(i).setCountry(person.getCountry());
                personList.get(i).setTravelInformation(person.getTravelInformation());
                personList.get(i).setVehicleNumber(person.getVehicleNumber());
                personList.get(i).setSeats(person.getSeats());
                personList.get(i).setStartDay(person.getStartDay());
                personList.get(i).setStartMonth(person.getStartMonth());
                personList.get(i).setStartYear(person.getStartYear());
                personList.get(i).setEndDay(person.getEndDay());
                personList.get(i).setEndMonth(person.getEndMonth());
                personList.get(i).setEndYear(person.getEndYear());
                personList.get(i).setDescription(person.getDescription());
            }
        }
    }

    @Override
    public Person findByIdCard(String idCard) {
        for(Person p: personList){
            if (p.getIdCard().equals(idCard)){
                return p;
            }
        }
        return null;
    }
}
