package com.account.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.account.entity.Account;
import com.account.entity.SentAccount;
import com.account.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	
	private AccountService service;
	private RestTemplate restTemplate;
 	private JmsTemplate jmsTemplate;
	 
	
	@Autowired
	public AccountController(AccountService service, RestTemplate restTemplate, JmsTemplate jmsTemplate) {
		this.service = service;
		this.restTemplate = restTemplate;
		this.jmsTemplate = jmsTemplate;
	}
	
	
	
	
	public AccountController() {
		
	}
	
	@GetMapping("/getAll")
	public List<Account> getAllAccounts() {
		return service.getAllAccounts();
	}
	
	@GetMapping("/getAnAccount/{id}")
	public Account getAnAccount(@PathVariable ("id") Long id) {
		return service.getAnAccount(id);
	}
	
	@PostMapping("/create")
	public Account createAccount(@RequestBody Account account) {
		String exchangeNum = restTemplate.getForObject("http://localhost:8082/genAccountNum", String.class);
		String exchangePrize = restTemplate.getForObject("http://localhost:8083/genPrize", String.class);
		account.setAccountNum(exchangeNum);
		account.setPrize(exchangePrize);
//		return exchangeNum;
//		return exchangePrize;
		sendToQueue(account);
		return service.createAccount(account);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteAnAccount(@PathVariable("id") Long id) {
		return service.deleteAccount(id);
	}
	
//	@GetMapping("/genPrize")
//	public String genPrize(@RequestBody String accountNum) {
//		ResponseEntity<String> exchangePrize = restTemplate.exchange("http://localhost:8083/genPrize", HttpMethod.GET, accountNum, String.class)
//	}
	
//	@GetMapping("/accountNum")
//	public String genAccountNum() {
//		String exchangeNum = restTemplate.getForObject("http://localhost:8082/genAccountNum", HttpMethod.GET, null, String.class);
//		return exchangeNum.getBody();
//	}
	
    private void sendToQueue(Account account){
        SentAccount accountToStore =  new SentAccount(account);
        jmsTemplate.convertAndSend("AccountQueue", accountToStore);
    }
	
}
