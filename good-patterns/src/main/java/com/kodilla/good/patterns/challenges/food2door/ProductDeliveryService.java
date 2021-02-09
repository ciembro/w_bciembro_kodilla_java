package com.kodilla.good.patterns.challenges.food2door;

public class ProductDeliveryService {

    InfomationService infomationService;

    public ProductDeliveryService(InfomationService infomationService) {
        this.infomationService = infomationService;
    }

    void process(OrderRequest orderRequest){
        if (orderRequest.getOrder().getProducer().process(orderRequest)) {
            infomationService.sendWhenOrderedAccepted(orderRequest);
        } else {
            infomationService.sendWhenOrderedDenied(orderRequest);
        }
    }


    public static void main(String[] args) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.getOrderRequest();

        ProductDeliveryService productDeliveryService = new ProductDeliveryService(new SmsService());

        productDeliveryService.process(orderRequest);




    }
}
