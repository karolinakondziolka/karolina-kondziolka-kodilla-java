package com.kodilla.good.patterns.challenges.food2door;

public class OrderRequest {

    String producerName;
    String productType;
    int productQuantity;
    double productWeight;

    public OrderRequest(String producerName, String productType, int productQuantity, double productWeight) {
        this.producerName = producerName;
        this.productType = productType;
        this.productQuantity = productQuantity;
        this.productWeight = productWeight;
    }

    public String getProducerName() {
        return producerName;
    }

    public String getProductType() {
        return productType;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public double getProductWeight() {
        return productWeight;
    }

}
