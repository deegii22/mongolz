package com.mongolz.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

public interface AccountService {
    public void publish(RabbitTemplate rabbitTemplate);

}
