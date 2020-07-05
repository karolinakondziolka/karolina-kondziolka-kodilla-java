package com.kodilla.good.patterns.challenges.allegro;

public class AGD implements Product {

    String productCategory;
    String productName;
    int productNumber;

    public AGD(String productCategory, String productName, int productNumber) {
        this.productCategory = productCategory;
        this.productName = productName;
        this.productNumber = productNumber;
    }

    @Override
    public String getProductCategory() {
        return productCategory;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public int getProductNumber() {
        return productNumber;
    }
}

