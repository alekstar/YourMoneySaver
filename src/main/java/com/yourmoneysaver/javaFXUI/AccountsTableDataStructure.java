package com.yourmoneysaver.javaFXUI;

import com.yourmoneysaver.Account;

public class AccountsTableDataStructure {
	private String name;
	private String type;
	private String rest;
	private String currencyCode;
	private String comments;

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	private void setType(String type) {
		this.type = type;
	}

	public String getRest() {
		return rest;
	}

	private void setRest(String rest) {
		this.rest = rest;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	private void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getComments() {
		return comments;
	}

	private void setComments(String comments) {
		this.comments = comments;
	}

	private char getDefaultSeparatorForNumbers() {
	    return ',';
    }

	public AccountsTableDataStructure(Account account) {
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
}
