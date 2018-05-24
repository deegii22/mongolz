package com.mongolz.aspect;

import com.mongolz.amqp.AlertService;
import com.mongolz.amqp.AlertServiceImpl;
import com.mongolz.domain.Transaction;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    @Pointcut("within(com.mongolz.service..*) && args(transaction)")
    public void tranMethod(Transaction transaction){};

    @AfterThrowing("tranMethod(transaction)")
    public void doLogging(JoinPoint joinPoint, Transaction transaction) throws Throwable{
        System.out.println("Transaction error:" + joinPoint.getSignature().getName());
    }

    @After("tranMethod(transaction)")
    public void infoTran(JoinPoint joinPoint, Transaction transaction) throws Throwable{

        System.out.println("   **********     TARGET CLASS : " +  Long.toString(transaction.getFromAccount().getId()) + " -> " +  Long.toString(transaction.getToAccount().getId()) +
                " " + transaction.getAmount() + " USD success. " + "    **********");

        // Mail send to email service
//        ApplicationContext context = new GenericXmlApplicationContext("classpath:spring/alert-app-context.xml");
//
//        RabbitTemplate transactionTemplate = context.getBean("alertTemplate", RabbitTemplate.class);
//        AlertService alertService = new AlertServiceImpl();
//        alertService.publish(transactionTemplate, transaction);
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        System.out.println("Sent mail ...");
    }

}
