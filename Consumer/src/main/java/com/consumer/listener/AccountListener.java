package com.consumer.listener;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.consumer.entity.SentAccount;
import com.consumer.repository.AccountConsumerRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AccountListener {

	private AccountConsumerRepository repo;
	
	@Autowired
	public AccountListener(AccountConsumerRepository repo) {
		this.repo = repo;
	}
	

	
	@JmsListener(destination = "AccountQueue", containerFactory = "jmsFactory")
	public void recieveAccount(SentAccount account) {
	
		
		//persist to mongodb
		 repo.save(account);
		 
		
	}
	
}
