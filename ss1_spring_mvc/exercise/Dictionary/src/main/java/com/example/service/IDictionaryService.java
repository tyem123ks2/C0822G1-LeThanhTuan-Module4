package com.example.service;

import java.util.Map;

public interface IDictionaryService {
    Map<String, String> getAllVocal();

    String translate(String word);
}
