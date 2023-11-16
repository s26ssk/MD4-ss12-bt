package com.ra.model.entity;

public class Product {
    private int productCode;
    private String productName;
    private double productPrice;

    private Category category;

    public Product() {
    }

    public Product(int productCode, String productName, double productPrice, Category category) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.category = category;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

