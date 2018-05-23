package com.mongolz.batch;

import com.mongolz.main.TransactionProcess;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TransactionBatch {

	@Autowired
	Job saveTransactions;
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	TransactionProcess transactionProcess;

	@Scheduled(fixedDelay= 15000, initialDelay=2000)
	public void startjob() throws  Exception {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("Starting batch " + dateFormat.format(date));  
		
 	    JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
	    jobParametersBuilder.addDate("date", new Date());
	    JobParameters jobParameters = jobParametersBuilder.toJobParameters();
	    JobExecution jobExecution = jobLauncher.run(saveTransactions, jobParameters);
	    BatchStatus batchStatus = jobExecution.getStatus();
	    
	    while (batchStatus.isRunning()) {
	        System.out.println("Still running...");
	        Thread.sleep(1000);
	    }
	    System.out.println("Exit status: " + jobExecution.getExitStatus().getExitCode());

	    JobInstance jobInstance = jobExecution.getJobInstance();
	    System.out.println("job instance Id: " + jobInstance.getId());
	    
	    // Print out current results...
	    // Further Product processing will be done interactively through ValidationGroupsDesktop
		transactionProcess.start();
	    System.out.println("DONE PROCESS");

	    System.exit(0);
	}
	
}
