package com.example.service.impl;

import com.example.repository.IDictionaryRepository;
import com.example.repository.impl.DictionaryRepository;
import com.example.service.IDictionaryService;

import java.util.Map;

public class DictionaryService implements IDictionaryService {
    private DictionaryRepository dictionaryRepository = new DictionaryRepository();
    @Override
    public Map<String, String> getAllVocal() {
        return dictionaryRepository.getAllVocal();
    }

    @Override
    public String translate(String word) {
        Map<String,String> map = dictionaryRepository.getAllVocal();
        for (String word1 : map.keySet()) {
            if (word.equals(word1)){
                return map.get(word1);
            }
        }
        return "Không tìm được";
    }
}
