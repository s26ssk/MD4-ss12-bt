package com.ra.model.service;

import com.ra.model.dao.ProductDAOImp;
import com.ra.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductDAOImp productDAO;

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Boolean create(Product product) {
        return productDAO.create(product);
    }

    @Override
    public Boolean update(Product product, Integer integer) {
        return productDAO.update(product, integer);
    }

    @Override
    public Product findId(Integer integer) {
        return productDAO.findId(integer);
    }

    @Override
    public void delete(Integer integer) {
        productDAO.delete(integer);
    }
}
