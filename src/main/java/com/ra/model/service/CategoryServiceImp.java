package com.ra.model.service;

import com.ra.model.dao.CategoryDAOImp;
import com.ra.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryDAOImp categoryDAO;

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Boolean create(Category category) {
        return categoryDAO.create(category);
    }

    @Override
    public Boolean update(Category category, Integer integer) {
        return categoryDAO.update(category, integer);
    }

    @Override
    public Category findId(Integer integer) {
        return categoryDAO.findId(integer);
    }

    @Override
    public void delete(Integer integer) {
        categoryDAO.delete(integer);
    }
}
