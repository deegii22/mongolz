package com.mongolz.main;

<<<<<<< HEAD
import com.mongolz.amqp.ItemService;
import com.mongolz.amqp.ItemServiceImpl;
=======
import com.mongolz.amqp.AlertService;
import com.mongolz.amqp.AlertServiceImpl;
import com.mongolz.domain.Transaction;
>>>>>>> 632e23014270302cb7a6999905d571872393af8a
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmqpProducerMain {
	
    public static void main(String[] args) {

<<<<<<< HEAD
        ApplicationContext context = new GenericXmlApplicationContext("classpath:spring/item-app-context.xml");
=======
        ApplicationContext context = new GenericXmlApplicationContext("classpath:spring/alert-app-context.xml");
>>>>>>> 632e23014270302cb7a6999905d571872393af8a

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.print("*************HIT RETURN********************* ::   ");
        System.out.println();
        try {
            in.readLine();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

<<<<<<< HEAD
        RabbitTemplate itemTemplate = context.getBean("itemTemplate", RabbitTemplate.class);
        ItemService itemService = new ItemServiceImpl();
        itemService.publish(itemTemplate);
=======
        RabbitTemplate transactionTemplate = context.getBean("transactionTemplate", RabbitTemplate.class);
        AlertService accountService = new AlertServiceImpl();
        Transaction transaction = new Transaction();
        accountService.publish(transactionTemplate, transaction);
>>>>>>> 632e23014270302cb7a6999905d571872393af8a

        System.out.println("Done ...");
 
    }
}
