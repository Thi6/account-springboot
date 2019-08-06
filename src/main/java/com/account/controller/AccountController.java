package com.account.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.entity.Account;
import com.account.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	
	private AccountService service;
	
	@Autowired
	public AccountController(AccountService service) {
		this.service = service;
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
		return service.createAccount(account);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteAnAccount(@PathVariable("id") Long id) {
		return service.deleteAccount(id);
	}
	
	
}
