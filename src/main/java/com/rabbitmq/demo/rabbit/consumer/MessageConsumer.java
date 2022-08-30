package com.rabbitmq.demo.rabbit.consumer;

import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    public void consumeMessage(final String message) {
        System.out.println(String.format("Receiving message: %s...", message));
    }
}
