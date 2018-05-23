/*
package com.mongolz.batch;

import com.mongolz.domain.Transaction;
import com.mongolz.service.TransactionService;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

*/
/*
 * Declared in user-job.xml
 *//*

public class TransactionItemWriter implements ItemWriter<Transaction>   {

 	private TransactionService transactionService;

	@Override
	public void write(List<? extends Transaction> transactions) throws Exception {
		for (Transaction transaction : transactions) {
 			transactionService.save(transaction);
		}
	}

	// Injected in user-job.xml
	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

}

*/
