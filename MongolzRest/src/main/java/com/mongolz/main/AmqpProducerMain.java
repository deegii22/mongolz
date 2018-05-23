package com.mongolz.main;

import com.mongolz.amqp.AlertService;
import com.mongolz.amqp.AlertServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmqpProducerMain {
	
    public static void main(String[] args) {

        ApplicationContext context = new GenericXmlApplicationContext("classpath:spring/alert-app-context.xml");

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

        RabbitTemplate transactionTemplate = context.getBean("transactionTemplate", RabbitTemplate.class);
        AlertService accountService = new AlertServiceImpl();
        accountService.publish(transactionTemplate);

        System.out.println("Done ...");
 
    }
}
