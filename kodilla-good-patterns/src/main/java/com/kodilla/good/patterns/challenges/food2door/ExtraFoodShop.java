package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

public class ExtraFoodShop implements Producer {

    String producerName;
    static String productType;
    int productQuantity;
    static double productWeight;
    private OrderRequest order;

    public ExtraFoodShop(void order) {
        this.order = order;
    }

    public static Map<String, Double> getProductList() {

        HashMap<String, Double> productList = new HashMap<>();
        productList.put("Truskawki", 40.0);
        productList.put("marchewka", 40.0);

        return productList;
    }

    public void shopOrder(){
    getProductList().entrySet().stream()
            .filter(e->e.getKey().equals(getProductType()))
            .filter(e-> e.getValue()<=getProductWeight())
            .forEach(System.out::println);
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
       getProductList().entrySet().stream()
                .filter(e -> e.getKey().equals(getProductType()))
                .filter(e -> e.getValue() <= getProductWeight())
                .forEach(System.out::println);


}
