package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDateTime;

public class OrderRequest {

    private BuyerInfo buyerInfo;
    private LocalDateTime dateOfOrder;
    private Product product;

    public OrderRequest(BuyerInfo buyerInfo, LocalDateTime dateOfOrder, Product product) {
        this.buyerInfo = buyerInfo;
        this.dateOfOrder = dateOfOrder;
        this.product = product;
    }

    public BuyerInfo getBuyerInfo() {
        return buyerInfo;
    }

    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }

    public Product getProduct() {
        return product;
    }
}
