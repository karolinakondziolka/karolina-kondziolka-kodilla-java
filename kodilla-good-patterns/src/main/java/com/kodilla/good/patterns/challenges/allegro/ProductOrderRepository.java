package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDateTime;

public class ProductOrderRepository implements OrderRepository{

    public boolean createOrder(BuyerInfo buyerInfo, LocalDateTime dateOfOrder, Product product){
        System.out.println("Order created");
        return true;
    }


}
