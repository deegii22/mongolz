package com.mongolz.amqp;

import com.mongolz.domain.Item;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class ItemServiceImpl implements ItemService {
    public void publish(RabbitTemplate rabbitTemplate) {

        Item i1 = new Item("Kazoo", 50.0, "Kazoo desc");
        Item i2 = new Item("Hammer", 10.0, "Hammer desc");

        rabbitTemplate.convertAndSend(i1);
        rabbitTemplate.convertAndSend(i2);


    }

}
