package com.kodilla.good.patterns.challenges.food2door;

public class OrderProcessor {

    private Producer producer;
    private OrderRequest orderRequest;

    public OrderProcessor(Producer producer, OrderRequest orderRequest){
        this.producer = producer;
        this.orderRequest = orderRequest;
    }

    public boolean orderProcess(){
        System.out.println("item ordered from: " + orderRequest.getProducerName() + "\ntype of item: " + orderRequest.getProductType() + "\nquantity/kg: " + orderRequest.getProductQuantity() + "/"+ orderRequest.getProductWeight());
        this.producer.process(orderRequest);
        return true;

    }

}
