package com.rabbitmq.demo.rabbit.producer;

import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MessageProducer {

    @Value("${spring.rabbitmq.exchange}")
    private String topicExchangeName;

    private final RabbitTemplate rabbitTemplate;

    public MessageProducer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 5000)
    public void produceMessage() {
        final String message = UUID.randomUUID().toString();
        System.out.println(String.format("Sending message %s...", message));
        rabbitTemplate.convertAndSend(topicExchangeName, StringUtils.EMPTY, message);
    }

}
