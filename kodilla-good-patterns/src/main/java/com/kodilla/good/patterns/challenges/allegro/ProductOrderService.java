package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDateTime;

public class ProductOrderService implements OrderServices{

    public boolean order(BuyerInfo buyerInfo, LocalDateTime dateOfOrder, Product product){
        System.out.println("Buyer details: \n\n"+ "nickname:" + buyerInfo.getBuyerNick() +"\nname:"+ buyerInfo.getBuyerName()+"\nsurname:"+ buyerInfo.getBuyerSurname() +"\naddress:"+ buyerInfo.getBuyerAddress()+"\nphone number:"+ buyerInfo.getPhoneNumber()+ "\n\nOrder details:\n" + "\ndate of order: "+ dateOfOrder.getDayOfWeek()+"\nordered product no:"+ product.getProductNumber() + "\nordered product:" + product.getProductName());
        return true;
    }

}
