package com.mongolz.aspect;

import com.mongolz.domain.Transaction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
public class TransactionAspect {

    @Pointcut("within(com.mongolz.service..*) && args(transaction)")
    public void tranMethod(Transaction transaction){};

    @AfterThrowing("tranMethod(transaction)")
    public void doLogging(JoinPoint joinPoint, Transaction transaction) throws Throwable{
        System.out.println("Transaction error:" + joinPoint.getSignature().getName());
    }

    @AfterReturning("tranMethod(transaction)")
    public void infoTran(JoinPoint joinPoint, Transaction transaction) throws Throwable{
        System.out.println(transaction.getFromAccount().getAccountName() + " -> " + transaction.getToAccount().getAccountName() +
        " " + transaction.getAmount() + " USD success. ");
    }

}
