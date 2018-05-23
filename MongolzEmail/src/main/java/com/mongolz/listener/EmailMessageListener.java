package com.mongolz.listener;

import com.mongolz.domain.RouteTransaction;
import com.mongolz.emailservice.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.mail.MessagingException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;


public class EmailMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(EmailMessageListener.class);

    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        RouteTransaction routeTransaction = null;
		try {
            routeTransaction = (RouteTransaction) objectMessage.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("EMAIL Item - Message received: " );
        System.out.println("         Item Name: "  +    routeTransaction.getChannel());
        System.out.println("         Item Name: "  +    routeTransaction.getTransaction().getAmount());

        ApplicationContext context = new ClassPathXmlApplicationContext("context/applicationContext.xml");

        String documentName = "AlarmClock.docx";
        String receiverEmail = routeTransaction.getTransaction().getFromAccount().getUser().getEmail();
        String recipientName = routeTransaction.getTransaction().getFromAccount().getUser().getFirstName();
        EmailService emailService = (EmailService) context.getBean("emailService");
        try {
            emailService.sendAlertReceivedMail(recipientName, receiverEmail,routeTransaction,new Locale("en"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        System.out.println("                      The Email is on the WAY!!!");
    }
}
