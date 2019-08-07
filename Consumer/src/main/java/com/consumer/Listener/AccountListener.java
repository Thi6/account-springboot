package com.consumer.Listener;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.consumer.entity.AccountSent;
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
	public void recieveAccount(String account) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		
		System.out.println("Received <" + account + ">");
		
		//converting string to AccountSent object
		AccountSent newAccount = objectMapper.readValue(account, AccountSent.class);

		//persist to mongodb
		 repo.save(newAccount);
		 
		 System.out.println(account + " processed ...");
	}
	
}
