package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

public class ExtraFoodShop implements Producer {

    String producerName;
    static String productType;
    int productQuantity;
    static double productWeight;


    public static Map<String, Double> getProductList() {

        HashMap<String, Double> productList = new HashMap<>();
        productList.put("Truskawki", 40.0);
        productList.put("marchewka", 40.0);

        return productList;
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
        Map<String, Double> productList =  getProductList();
        Double quantity = productList.get(orderRequest.getProductType());
        if(quantity>= orderRequest.getProductWeight()){
            System.out.println("Order has been sent");
            return true;
        }else{
            return false;
        }

    }



}
