package com.example.repository.impl;

import com.example.repository.IDictionaryRepository;

import java.util.HashMap;
import java.util.Map;

public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String,String> map = new HashMap<>();
    static {
        map.put("Lion","Sư tử");
        map.put("Tiger","Hổ");
        map.put("Mouse","Chuột");
        map.put("Buffalo","Trâu");
        map.put("Cat","Mèo");
        map.put("Dragon","Rồng");
        map.put("Snake","Rắn");
        map.put("Chicken","Gà");
        map.put("Pig","Heo");
        map.put("Dog","Chó");
    }

    @Override
    public Map<String, String> getAllVocal() {
        return map;
    }

    @Override
    public String translate(String word) {
        Map<String,String> map = getAllVocal();
        for (String word1 : map.keySet()){
            if (word1.equals(word)){
                return map.get(word1);
            }
        }
        return  "Không tìm thấy";
    }
}
