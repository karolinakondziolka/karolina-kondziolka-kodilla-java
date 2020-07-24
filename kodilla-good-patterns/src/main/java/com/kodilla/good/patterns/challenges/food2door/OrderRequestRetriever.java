package com.kodilla.good.patterns.challenges.food2door;

public class OrderRequestRetriever {

    public OrderRequest retrieve(){

        return new OrderRequest("GlutenFreeShop", "sok", 5, 0);
    }
}
