package com.account.service;

import java.util.List;

import com.account.entity.Account;

public interface AccountService {
	
	List<Account> getAllAccounts();
	Account getAnAccount(Long accountId);
	Account createAccount(Account account);
}
