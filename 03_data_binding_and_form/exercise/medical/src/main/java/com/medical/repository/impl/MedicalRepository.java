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
    private static Person person;
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
}
