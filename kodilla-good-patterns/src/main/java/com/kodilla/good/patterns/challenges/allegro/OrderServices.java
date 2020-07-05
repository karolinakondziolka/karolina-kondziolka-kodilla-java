package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDateTime;

public interface OrderServices {
    boolean order(BuyerInfo buyerInfo, LocalDateTime dateOfOrder, Product product);
}
