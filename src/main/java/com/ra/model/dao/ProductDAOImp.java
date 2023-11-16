    package com.ra.model.dao;

    import com.ra.model.entity.Category;
    import com.ra.model.entity.Product;
    import com.ra.util.ConnectionDB;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Repository;

    import java.sql.*;
    import java.util.ArrayList;
    import java.util.List;
    @Repository
    public class ProductDAOImp implements ProductDAO {
        @Autowired
        private CategoryDAO categoryDAO;

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
                            Category category = categoryDAO.findId(resultSet.getInt("categoryId"));
                            product.setCategory(category);
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
                try (CallableStatement callableStatement = connection.prepareCall("{CALL AddProduct(?, ?, ?)}")) {
                    callableStatement.setString(1, product.getProductName());
                    callableStatement.setDouble(2, product.getProductPrice());
                    callableStatement.setInt(3, product.getCategory().getCategoryId());
                    int check = callableStatement.executeUpdate();
                    return check > 0;
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
                try (CallableStatement callableStatement = connection.prepareCall("{CALL UpdateProduct(?, ?, ?, ?)}")) {
                    callableStatement.setInt(1, productCode);
                    callableStatement.setString(2, product.getProductName());
                    callableStatement.setDouble(3, product.getProductPrice());
                    callableStatement.setInt(4, product.getCategory().getCategoryId());
                    int check = callableStatement.executeUpdate();
                    return check > 0;
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
                            product.setCategory(categoryDAO.findId(resultSet.getInt("categoryId")));
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
