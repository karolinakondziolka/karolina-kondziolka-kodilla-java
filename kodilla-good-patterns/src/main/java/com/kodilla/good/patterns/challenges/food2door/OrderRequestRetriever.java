package com.kodilla.good.patterns.challenges.food2door;

public class OrderRequestRetriever {

    public OrderRequest retrieve(){
        return new OrderRequest("ExtraFoodShop", "Truskawki", 0, 20.0);
    }
}
