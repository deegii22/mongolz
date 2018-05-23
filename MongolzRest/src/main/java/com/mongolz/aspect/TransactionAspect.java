package com.mongolz.aspect;

import com.mongolz.amqp.AlertService;
import com.mongolz.amqp.AlertServiceImpl;
import com.mongolz.domain.Transaction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Aspect
@Component
public class TransactionAspect {

    @Pointcut("within(com.mongolz.service..*) && args(transaction)")
    public void tranMethod(Transaction transaction){};

    @AfterThrowing("tranMethod(transaction)")
    public void doLogging(JoinPoint joinPoint, Transaction transaction) throws Throwable{
        System.out.println("Transaction error:" + joinPoint.getSignature().getName());
    }

    @Before("tranMethod(transaction)")
    public void infoTran(JoinPoint joinPoint, Transaction transaction) throws Throwable{
        System.out.println(transaction.getFromAccount().getAccountName() + " -> " + transaction.getToAccount().getAccountName() +
        " " + transaction.getAmount() + " USD success. ");

        // Mail send to email service
        ApplicationContext context = new GenericXmlApplicationContext("classpath:spring/alert-app-context.xml");

        RabbitTemplate transactionTemplate = context.getBean("alertTemplate", RabbitTemplate.class);
        AlertService alertService = new AlertServiceImpl();
        alertService.publish(transactionTemplate, transaction);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Sent mail ...");
    }

}
