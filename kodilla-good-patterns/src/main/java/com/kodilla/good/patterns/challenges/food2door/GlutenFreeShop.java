package com.kodilla.good.patterns.challenges.food2door;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GlutenFreeShop implements Producer {

    String producerName;
    String productType;
    int productQuantity;
    double productWeight;

    public static List<String> getSokJablkowy(){
        ArrayList<String> sokJablkowy = new ArrayList<>();
        sokJablkowy.add("jablkowy");
        sokJablkowy.add("jablkowy");
        sokJablkowy.add("jablkowy");
        sokJablkowy.add("jablkowy");


        return sokJablkowy;
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
        List<String> sokJablkowy = getSokJablkowy();
        if (sokJablkowy.size()>=orderRequest.getProductQuantity()) {
            System.out.println("Order from GlutenFreeShop has been sent");
            return true;
        } else {
            System.out.println("Sorry, we do not have enough stuff");
            return false;


        }
    }
}
