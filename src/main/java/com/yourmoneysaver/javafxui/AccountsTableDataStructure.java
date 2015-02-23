package com.yourmoneysaver.javafxui;

import com.yourmoneysaver.Account;

public class AccountsTableDataStructure {
	private Account account;
	private String name;
	private String type;
	private String rest;
	private String currencyCode;
	private String comments;
	
	public AccountsTableDataStructure(Account account) {
		setAccount(account);
		setName(account.getName());
		setType(account.getAccountType().getName());
		StringBuilder restStringBuilder = new StringBuilder();
		restStringBuilder.append(account.getRest().getBase());
		restStringBuilder.append(getDefaultSeparatorForNumbers());
		restStringBuilder.append(account.getRest().getCoins());
		setRest(restStringBuilder.toString());
		setCurrencyCode(account.getRest().getCurrency().getIsoCode());
		setComments(account.getComments());
	}

	public Account getAccount() {
		return account;
	}

	public String getComments() {
		return comments;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	private char getDefaultSeparatorForNumbers() {
	    return ',';
    }

	public String getName() {
		return name;
	}

	public String getRest() {
		return rest;
	}

	public String getType() {
		return type;
	}

	public void setAccount(Account account) {
		if(account == null) {
			throw new IllegalArgumentException("Argument account is null.");
		}
		this.account = account;
	}

	private void setComments(String comments) {
		this.comments = comments;
	}

	private void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setRest(String rest) {
		this.rest = rest;
	}

	private void setType(String type) {
		this.type = type;
	}
}
