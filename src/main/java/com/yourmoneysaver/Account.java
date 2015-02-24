package com.yourmoneysaver;

import com.yourmoneysaver.exceptions.ArgumentIsNullException;

public class Account {
	Money rest;
	AccountType accountType;
	String name;
	String comments;

	public Account(String name, AccountType accountType, Money rest,
            String comments) {
		setRest(rest);
		setAccountType(accountType);
		setName(name);
		setComments(comments);
    }

	public AccountType getAccountType() {
		return accountType;
	}

	public String getComments() {
		return comments;
	}

	public String getName() {
		return name;
	}

	public Money getRest() {
		return rest;
	}

	public void setAccountType(AccountType accountType) {
		if(accountType == null) {
			throw new ArgumentIsNullException("accountType");
		}
		this.accountType = accountType;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRest(Money rest) {
		if(rest == null) {
			throw new ArgumentIsNullException("rest");
		}
		this.rest = rest;
	}
	
	
}
