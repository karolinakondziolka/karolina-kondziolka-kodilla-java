package com.kodilla.good.patterns.challenges.food2door;

public class GlutenFreeShop implements Producer {

    String producerName;
    String productType;
    int productQuantity;
    double productWeight;

    @Override
    public String getProducerName() {
        return producerName;
    }

    @Override
    public String getProductType() {
        return productType;
    }

    @Override
    public int getProductQuantity() {
        return productQuantity;
    }

    @Override
    public double getProductWeight() {
        return productWeight;
    }

    @Override
    public void process(OrderRequest orderRequest) {

    }
}