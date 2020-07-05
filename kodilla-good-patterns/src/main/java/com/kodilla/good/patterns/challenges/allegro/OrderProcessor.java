package com.kodilla.good.patterns.challenges.allegro;

public class OrderProcessor {
    private InformationService informationService;
    private OrderServices orderServices;
    private OrderRepository orderRepository;

    public OrderProcessor(InformationService informationService, OrderServices orderServices, OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderServices = orderServices;
        this.orderRepository = orderRepository;
    }

    public OrderDto process( final OrderRequest orderRequest){
        boolean isOrdered = orderServices.order(orderRequest.getBuyerInfo(), orderRequest.getDateOfOrder(), orderRequest.getProduct());

        if(isOrdered) {
            informationService.inform(orderRequest.getBuyerInfo());
            orderRepository.createOrder(orderRequest.getBuyerInfo(), orderRequest.getDateOfOrder(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getBuyerInfo(), true);
        }else{
            return new OrderDto(orderRequest.getBuyerInfo(), false);
        }
    }

}
