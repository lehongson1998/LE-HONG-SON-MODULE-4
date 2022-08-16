package com.sandwich.service;

import java.util.List;

public interface ISandwichService {
    List<String> finAllSpice();
    List<String> saveSpice(String[] condiment);
}
