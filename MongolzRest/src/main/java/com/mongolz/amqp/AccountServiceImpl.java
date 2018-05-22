package com.mongolz.amqp;

import com.mongolz.domain.Account;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class AccountServiceImpl implements AccountService {
    public void publish(RabbitTemplate rabbitTemplate) {

        Account a1 = new Account();
        Account a2 = new Account();

        rabbitTemplate.convertAndSend(a1);
        rabbitTemplate.convertAndSend(a2);


    }

}
