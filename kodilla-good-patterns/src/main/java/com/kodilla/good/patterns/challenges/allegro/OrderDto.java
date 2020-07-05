package com.kodilla.good.patterns.challenges.allegro;

public class OrderDto {

    public BuyerInfo buyerInfo;
    public boolean isOrdered;

    public OrderDto(BuyerInfo buyerInfo, boolean isOrdered) {
        this.buyerInfo = buyerInfo;
        this.isOrdered = isOrdered;
    }

    public BuyerInfo getBuyerInfo(){
        return buyerInfo;
    }

    public boolean isOrdered(){
        return isOrdered;
    }
}
