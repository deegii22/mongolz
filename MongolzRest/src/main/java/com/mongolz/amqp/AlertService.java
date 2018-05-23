package com.mongolz.amqp;

import com.mongolz.domain.Transaction;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public interface AlertService {
    public void publish(RabbitTemplate rabbitTemplate, Transaction transaction);

}
