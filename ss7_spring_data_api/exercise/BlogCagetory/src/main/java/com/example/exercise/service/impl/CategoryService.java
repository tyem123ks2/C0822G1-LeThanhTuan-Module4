package com.example.exercise.service.impl;

import com.example.exercise.model.Blog;
import com.example.exercise.model.Category;
import com.example.exercise.repository.ICagetoryRepository;
import com.example.exercise.service.ICagetoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICagetoryService {

    @Autowired
    private ICagetoryRepository cagetoryRepository;

    @Override
    public List<Category> showAllCategory() {
        return cagetoryRepository.findAll();
    }

    @Override
    public boolean addNewCategory(Category category) {
        try{
            if (cagetoryRepository.findByName(category.getName()) == null){
                throw new SQLDataException();
            }
            cagetoryRepository.save(category);
        } catch (IllegalArgumentException | OptimisticLockingFailureException | SQLDataException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateCategory(Category category) {
        if (!cagetoryRepository.existsById(category.getId())) {
            return false;
        }
        try {
            cagetoryRepository.save(category);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean removeCategory(int id) {
        try {
            cagetoryRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    @Override
    public Optional<Category> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Page<Category> findByNameCategory(String name, Pageable pageable) {
        return cagetoryRepository.findByNameCategoryy(name, pageable);}

}
