package com.mongolz.main;

import com.mongolz.amqp.AlertService;
import com.mongolz.amqp.AlertServiceImpl;
import com.mongolz.domain.Account;
import com.mongolz.domain.Transaction;
import com.mongolz.domain.User;
import com.mongolz.service.TransactionService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

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

        RabbitTemplate alertTemplate = context.getBean("alertTemplate", RabbitTemplate.class);
        AlertService alertService = new AlertServiceImpl();
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal(123000.0));
        Account account = new Account();
        User user = new User();
        user.setChannel("EMAIL");
        user.setEmail("deegii212@gmail.com");
        user.setFirstName("Deegii");
        account.setUser(user);
        transaction.setFromAccount(account);
        alertService.publish(alertTemplate, transaction);

        System.out.println("Done ...");
 
    }
}
