package com.kodilla.good.patterns.challenges.allegro;

public class BuyerInfo {

    private String buyerNick;
    private String buyerName;
    private String buyerSurname;
    private String buyerAddress;
    private long phoneNumber;

    public BuyerInfo(String buyerNick, String buyerName, String buyerSurname, String buyerAddress, long phoneNumber) {
        this.buyerNick = buyerNick;
        this.buyerName = buyerName;
        this.buyerSurname = buyerSurname;
        this.buyerAddress = buyerAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getBuyerSurname() {
        return buyerSurname;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }
}
