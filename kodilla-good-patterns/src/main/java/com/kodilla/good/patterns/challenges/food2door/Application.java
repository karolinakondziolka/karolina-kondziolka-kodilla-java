package com.kodilla.good.patterns.challenges.food2door;

public class Application {

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();
        OrderProcessor orderProcessor = new OrderProcessor(new GlutenFreeShop(), orderRequest);
        orderProcessor.orderProcess();
    }

}
