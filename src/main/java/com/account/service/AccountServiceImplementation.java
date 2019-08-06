package com.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.entity.Account;
import com.account.repository.AccountRepository;

@Service
public class AccountServiceImplementation implements AccountService{
	
	

	private AccountRepository repo;
	
	@Autowired
	public AccountServiceImplementation(AccountRepository repo) {
		this.repo = repo;
	}
	
	public AccountServiceImplementation() {
		
	}
 	
	public List<Account> getAllAccounts() {
		return repo.findAll();
	}

	public Account getAnAccount(Long accountId) {
		return repo.findById(accountId).orElse(null);		
	}
	
	public Account createAccount(Account account) {
		return repo.save(account);
	}
 
	public String deleteAccount(Long accountId) {
		
		Boolean accountExists = repo.findById(accountId).isPresent();
		String message = "";
	 	
		if (accountExists) {
			repo.deleteById(accountId);
			message = "Account has been deleted!";
		} else {
			message = "This account does not exist!";
		}
		return message;
	}

	public String numberGenerator() {
		
		return null;
	}

}
