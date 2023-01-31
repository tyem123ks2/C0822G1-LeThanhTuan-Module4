package com.example.repository;

import java.util.Map;

public interface IDictionaryRepository {
    Map<String, String> getAllVocal();

    String translate(String word);
}
