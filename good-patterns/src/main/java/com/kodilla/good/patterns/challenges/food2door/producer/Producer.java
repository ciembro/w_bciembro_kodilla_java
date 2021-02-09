package com.kodilla.good.patterns.challenges.food2door.producer;

import com.kodilla.good.patterns.challenges.food2door.OrderRequest;

public abstract class Producer {

    protected final String producerName;
    protected final ProducerWarehouse producerWarehouse;

    public Producer(String producerName, ProducerWarehouse producerWarehouse) {
        this.producerName = producerName;
        this.producerWarehouse = producerWarehouse;
    }

    public String getProducerName() {
        return producerName;
    }

    public ProducerWarehouse getProducerWarehouse() {
        return producerWarehouse;
    }

    public abstract boolean process(OrderRequest orderRequest);
}
