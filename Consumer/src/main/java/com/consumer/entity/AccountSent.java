package com.consumer.entity;

public class AccountSent {

	private String accountId;

	private String firstName;

	private String lastName;

	private String accountNumber;

	private String prize;

	public AccountSent() {

	}

	public AccountSent(AccountSent account) {
		this.accountId = account.getAccountId();
		this.firstName = account.getFirstName();
		this.lastName = account.getLastName();
		this.prize = account.getPrize();
		this.accountNumber = account.getAccountNumber();
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

}
