package com.kodilla.good.patterns.challenges.food2door;

public interface Producer {

    String getProducerName();
    String getProductType();
    int getProductQuantity();
    double getProductWeight();


    void process(OrderRequest orderRequest);
}
