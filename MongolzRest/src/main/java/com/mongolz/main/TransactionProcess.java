package com.mongolz.main;

import com.mongolz.domain.Transaction;
import com.mongolz.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class TransactionProcess {

 	@Autowired
	TransactionService transactionService;
	
 	public void start() throws IOException {
		
 		  System.out.println("******* List of Transactions AND Status");
	
		 List<Transaction> transactions = transactionService.findAll();
		 for (Transaction transaction : transactions) {
			 System.out.println();
			 System.out.print("Product name: " + transaction.getId()
			        + "  Status: " + transaction.getFromAccount());
		 }
		 System.out.println();
		 
	}
}
