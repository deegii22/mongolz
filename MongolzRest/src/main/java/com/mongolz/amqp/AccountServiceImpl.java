package com.mongolz.amqp;

import com.mongolz.domain.Account;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class AccountServiceImpl implements AccountService {
    public void publish(RabbitTemplate rabbitTemplate) {

        Account a1 = new Account("1234",1000);
        Account a2 = new Account("5678",1000);

        rabbitTemplate.convertAndSend(a1);
        rabbitTemplate.convertAndSend(a2);


    }

}
