package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderRequestRetriever {

    public OrderRequest retrieve(){

        BuyerInfo buyerInfo = new BuyerInfo("Legolas", "Jan", "Kowalski", "Prosta 9", 555555555);
        LocalDateTime dateOfOrder = LocalDateTime.of(2020, 07, 05, 14, 19);
        Product product = new AGD("Małe AGD", "Blender", 36273846);

        return new OrderRequest(buyerInfo, dateOfOrder, product);

    }

}
