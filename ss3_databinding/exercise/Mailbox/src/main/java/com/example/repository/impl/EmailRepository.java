package com.example.repository.impl;
import com.example.model.Email;
import com.example.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
    private static List<Email> emailList;

    static {
        emailList = new ArrayList<>();
        emailList.add(new Email(1, "Vietnamese", 10, true, "no"));
        emailList.add(new Email(2, "English", 15, true, "no"));
        emailList.add(new Email(3, "Chinese", 20, true, "no"));
    }
    @Override
    public List<Email> findAll() {
        return emailList;
    }

    @Override
    public void update(Email email) {
        for (Email item: emailList) {
            if (email.getId() == item.getId()){
                item.setLanguage(email.getLanguage());
                item.setPageSize(email.getPageSize());
                item.setSpamFilter(email.isSpamFilter());
                item.setSignature(email.getSignature());
                break;
            }
        }
    }

    @Override
    public Email findById(int id) {
        for (Email items : emailList) {
            if (items.getId() == id) {
                return items;
            }
        }
        return null;
    }

    @Override
    public List<String> findLanguage() {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Chinese");
        languageList.add("Japanese");
        return languageList;
    }

    @Override
    public List<Integer> findPageSize() {
        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        return pageSizeList;
    }
}
