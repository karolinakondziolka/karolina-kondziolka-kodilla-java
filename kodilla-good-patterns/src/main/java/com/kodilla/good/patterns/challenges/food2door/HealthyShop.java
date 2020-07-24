package com.kodilla.good.patterns.challenges.food2door;

import java.util.*;

public class HealthyShop implements Producer {

    String producerName;
    String productType;
    int productQuantity;
    double productWeight;

    public static List<String> getPszenny(){
        LinkedList<String> pszenny = new LinkedList<>();
        pszenny.add("pszenny");
        pszenny.add("pszenny");
        pszenny.add("pszenny");

        return pszenny;
    }

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
        List<String> pszenny = getPszenny();
        if (pszenny.size()>=orderRequest.getProductQuantity()) {
            System.out.println("Order from HealthyShop has been sent");
            return true;
        } else {
            System.out.println("Sorry, we do not have enough stuff");
            return false;
        }

    }
}
