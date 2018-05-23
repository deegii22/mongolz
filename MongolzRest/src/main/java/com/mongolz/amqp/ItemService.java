package com.mongolz.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

public interface ItemService {
    public void publish(RabbitTemplate rabbitTemplate);

}
