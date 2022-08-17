package com.email.repository.impl;

import com.email.model.Email;
import com.email.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
    private static Email email = new Email("English", 5, true, "signature king");
    private static List<String> languagesList = new ArrayList<>();
    private static List<Integer> pageSizeList = new ArrayList<>();
    static {
        languagesList.add("English");
        languagesList.add("Vietnamese");
        languagesList.add("Japanese");
        languagesList.add("Chinese");
    }
    static {
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
    }
    @Override
    public List<String> languages() {
        return languagesList;
    }

    @Override
    public List<Integer> pageSize() {
        return pageSizeList;
    }

    @Override
    public void save(Email emailBox) {
        email.setLanguages(emailBox.getLanguages());
        email.setPageSize(emailBox.getPageSize());
        email.setSpamFilter(emailBox.isSpamFilter());
        email.setSignature(emailBox.getSignature());
    }

    @Override
    public Email display() {
        return email;
    }
}
