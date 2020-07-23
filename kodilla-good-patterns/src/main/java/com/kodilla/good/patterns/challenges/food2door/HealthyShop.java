package com.kodilla.good.patterns.challenges.food2door;

public class HealthyShop implements Producer {

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
    public boolean process(OrderRequest orderRequest) {
        System.out.println("Order has been confirmed:" + orderRequest.getProductType() + "\n weight of product:" + orderRequest.getProductWeight());
        return false;

    }
}
