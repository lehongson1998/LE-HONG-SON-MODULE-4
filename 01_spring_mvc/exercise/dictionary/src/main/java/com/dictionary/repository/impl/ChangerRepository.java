package com.dictionary.repository.impl;

import com.dictionary.repository.IChangerRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChangerRepository implements IChangerRepository {
    private static Map<String, String> dictionary = new HashMap<>();
    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("good morning", "xin chào buổi sáng");
        dictionary.put("good", "tốt");
        dictionary.put("in", "trong");
        dictionary.put("on", "trên");
        dictionary.put("edit", "chỉnh sửa");
        dictionary.put("delete", "xóa");
        dictionary.put("create", "thêm mới");
        dictionary.put("china", "trung quốc");
        dictionary.put("japan", "nhật bản");
        dictionary.put("america", "hoa kì");
        dictionary.put("cambodia", "campuchia");
        dictionary.put("champion", "nhà vô địch");
        dictionary.put("legend", "huyền thoại");
        dictionary.put("changer", "chuyển đổi");
    }

    @Override
    public String changer(String key) {
        String eng = key.toLowerCase();
        return dictionary.get(eng);
    }
}
