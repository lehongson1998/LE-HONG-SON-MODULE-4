package com.sandwich.repository.impl;

import com.sandwich.repository.ISandwichRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SandwichRepository implements ISandwichRepository {
    private static List<String> spice = new ArrayList<>();
    static {
        spice.add("Lettuce");
        spice.add("Tomato");
        spice.add("Mustard");
        spice.add("Sprouts");
    }
    @Override
    public List<String> finAllSpice() {
        return spice;
    }

    @Override
    public List<String> saveSpice(String[] condiment) {
        List<String> selectSpice = new ArrayList<>();
        for (int i = 0; i < condiment.length; i++) {
            selectSpice.add(condiment[i]);
        }
        return selectSpice;
    }
}
