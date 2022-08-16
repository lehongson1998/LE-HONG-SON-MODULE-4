package com.sandwich.repository;

import java.util.List;

public interface ISandwichRepository {
    List<String> finAllSpice();
    List<String> saveSpice(String[] condiment);
}
