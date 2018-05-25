package com.mongolz.main;


import com.mongolz.batch.TransactionBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Main {
 
	@Autowired
	TransactionBatch transactionBatch;
	
  public static void main(String[] args) throws Throwable {

    ApplicationContext context = new ClassPathXmlApplicationContext("context/applicationContext.xml",
    		"context/user-job.xml",
			"context/security-context.xml");
    	context.getBean(Main.class).mainInternal(context);
  	}
    private void mainInternal(ApplicationContext applicationContext) throws Exception {
 
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	System.out.println("Starting System " + dateFormat.format(date));  
   
	// This "manual mode" ...ProductBatch will be SCHEDULED if @Scheduled is on ProductBatch Class
		transactionBatch.startjob();
	
  }
 }
