package com.kodilla.good.patterns.challenges.allegro;

public class MailServices implements InformationService {
    @Override
    public void inform(BuyerInfo buyerInfo) {
        System.out.println("Confirmation of order sent to buyer");
    }
}
