package com.account.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.entity.Account;
import com.account.service.AccountService;

@RestController

public class AccountController {
	
	
	private AccountService service;
	
	@Autowired
	public AccountController(AccountService service) {
		this.service = service;
	}
	
	@GetMapping("/getAll")
	public List<Account> getAllAccounts() {
		return service.getAllAccounts();
	}
	
	@PostMapping("/create")
	public Account createAccount(@RequestBody Account account) {
		return service.createAccount(account);
	}
	
}
