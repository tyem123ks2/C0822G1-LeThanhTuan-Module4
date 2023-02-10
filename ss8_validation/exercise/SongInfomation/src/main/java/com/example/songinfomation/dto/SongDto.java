package com.example.songinfomation.dto;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SongDto  implements Validator {
    private int id;
//    @NotNull(message = "Could not be void!")
//    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Cannot contain numeric characters")
    private String name;

//    @NotNull(message = "Could not be void!")
//    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Cannot contain numeric characters")
    private String singer;

//    @NotNull(message = "Could not be void!")
//    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Cannot contain numeric characters")
    private String category;
    public SongDto(int id, String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public SongDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        String name = songDto.getName();
            if (!name.matches("^[a-zA-Z\\s]+$")){
                errors.rejectValue("name", "name", "Tên không hợp lệ");
            }
        String singer = songDto.getSinger();
        if (!singer.matches("^[a-zA-Z\\s]+$")){
            errors.rejectValue("singer", "singer", "Tên không hợp lệ");
        }
        String category = songDto.getCategory();
        if (!category.matches("^[a-zA-Z\\s]+$")){
            errors.rejectValue("category", "category", "Tên không hợp lệ");
        }
    }
}
