package com.mongolz.amqp;

import com.mongolz.domain.Transaction;
import com.mongolz.domain.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class AlertServiceImpl implements AlertService {
    public void publish(RabbitTemplate rabbitTemplate, Transaction transaction) {

        rabbitTemplate.convertAndSend(transaction);

    }

}
