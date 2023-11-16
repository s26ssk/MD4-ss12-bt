package com.ra.model.service;

import com.ra.model.dao.CategoryDAOImp;
import com.ra.model.entity.Category;

import java.util.List;

public class CategoryService implements IGenericService<Category, Integer> {
    private final CategoryDAOImp categoryDAO = new CategoryDAOImp();

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Boolean create(Category category) {
        return null;
    }

    @Override
    public Boolean update(Category category, Integer integer) {
        return null;
    }

    @Override
    public Category findId(Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
