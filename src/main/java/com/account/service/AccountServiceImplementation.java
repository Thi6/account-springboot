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
	
	
	public AccountServiceImplementation(@Autowired AccountRepository repo) {
		this.repo = repo;
	}
	
	
	public List<Account> getAllAccounts() {
		return repo.findAll();
	}

	
	public Account createAccount(Account account) {
		return repo.save(account);
	}


	public Account getAnAccount(Long accountId) {
		return repo.findById(accountId).orElse(null);
	}



}
