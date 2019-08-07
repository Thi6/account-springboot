package com.account.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.http.ResponseEntity;

@Entity
public class Account {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	private String accountNum;
	private String firstname;
	private String lastname;
	private String prize;
	
	public Account(Long accountId, String accountNum, String firstname, String lastname, String prize) {
		super();
		this.accountId = accountId;
		this.accountNum = accountNum;
		this.firstname = firstname;
		this.lastname = lastname;
		this.prize = prize;
	}
	
	public Account() {
		super();
		
	}
	
 	
	// getters and setters
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}
	
}
