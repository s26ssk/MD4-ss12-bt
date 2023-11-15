package com.ra.model.dao;

import com.ra.model.entity.Product;
import com.ra.model.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImp implements IGenericDAO<Product, Integer> {

    @Override
    public List<Product> findAll() {
        Connection connection = null;
        List<Product> productList = new ArrayList<>();

        try {
            connection = ConnectionDB.getConnection();
            try (CallableStatement callableStatement = connection.prepareCall("{CALL GetAllProducts()}")) {
                try (ResultSet resultSet = callableStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Product product = new Product();
                        product.setProductCode(resultSet.getInt("productCode"));
                        product.setProductName(resultSet.getString("productName"));
                        product.setProductPrice(resultSet.getDouble("productPrice"));
                        productList.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return productList;
    }

    @Override
    public Boolean create(Product product) {
        Connection connection = null;
        try {
            connection = ConnectionDB.getConnection();
            try (CallableStatement callableStatement = connection.prepareCall("{CALL AddProduct(?, ?)}")) {
                callableStatement.setString(1, product.getProductName());
                callableStatement.setDouble(2, product.getProductPrice());
                int rowsAffected = callableStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Boolean update(Product product, Integer productCode) {
        Connection connection = null;
        try {
            connection = ConnectionDB.getConnection();
            try (CallableStatement callableStatement = connection.prepareCall("{CALL UpdateProduct(?, ?, ?)}")) {
                callableStatement.setInt(1, productCode);
                callableStatement.setString(2, product.getProductName());
                callableStatement.setDouble(3, product.getProductPrice());
                int rowsAffected = callableStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Product findId(Integer productCode) {
        Connection connection = null;
        try {
            connection = ConnectionDB.getConnection();
            try (CallableStatement callableStatement = connection.prepareCall("{CALL GetProductById(?)}")) {
                callableStatement.setInt(1, productCode);
                try (ResultSet resultSet = callableStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Product product = new Product();
                        product.setProductCode(resultSet.getInt("productCode"));
                        product.setProductName(resultSet.getString("productName"));
                        product.setProductPrice(resultSet.getDouble("productPrice"));
                        return product;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public void delete(Integer productCode) {
        Connection connection = null;
        try {
            connection = ConnectionDB.getConnection();
            try (CallableStatement callableStatement = connection.prepareCall("{CALL DeleteProduct(?)}")) {
                callableStatement.setInt(1, productCode);
                callableStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
