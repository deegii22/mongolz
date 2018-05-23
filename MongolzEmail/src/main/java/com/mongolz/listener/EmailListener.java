package com.mongolz.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.mail.MessagingException;

import com.mongolz.domain.Account;
import com.mongolz.domain.Transaction;
import com.mongolz.emailservice.EmailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;


public class EmailListener implements MessageListener {
 
    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        Transaction transaction = null;
		try {
            transaction = (Transaction) objectMessage.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Email transaction - Message received: " );
        System.out.println("         Item Name: "  + transaction.getId());

        // Send email
        ApplicationContext context = new ClassPathXmlApplicationContext("context/applicationContext.xml");

        String documentName = "AlarmClock.docx";
        String receiverEmail = transaction.getFromAccount().getUser().getEmail();
        String recipientName = transaction.getFromAccount().getUser().getFirstName();
        EmailService emailService = (EmailService) context.getBean("emailService");
        try {
            emailService.sendAlertReceivedMail(recipientName, receiverEmail,transaction,documentName,new Locale("en"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        System.out.println("                      The Email is on the WAY!!!");

    }
}
