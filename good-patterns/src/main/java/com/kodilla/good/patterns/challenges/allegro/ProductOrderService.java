package com.kodilla.good.patterns.challenges.allegro;

public class ProductOrderService {
    InformationService informationService;
    TransactionService transactionService;
    OrderRepository orderRepository;

    public ProductOrderService(final InformationService informationService,
                               final TransactionService transactionService,
                               final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.transactionService = transactionService;
        this.orderRepository = orderRepository;
    }

    public void process(final OrderRequest orderRequest){
        boolean isSold = transactionService.sell();

        if (isSold){
            informationService.sendProductHasBeenShippedMessage(orderRequest);
            orderRepository.createOrder(new TransactionDto(orderRequest, true));
        } else {
            orderRepository.createOrder(new TransactionDto(orderRequest, false));
        }
    }

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.getData();

        TransactionService transactionService = new TransactionService(orderRequest,
                new BankTransferPaymentProcessor());
        ProductOrderService productOrderService = new ProductOrderService(new MailService(),
                transactionService, new MapOrderRepository());

        productOrderService.process(orderRequest);

    }
}


