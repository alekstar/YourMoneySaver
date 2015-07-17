package com.alekstar.yourmoneysaver.domain;

import com.alekstar.yourmoneysaver.domain.exceptions.ArgumentIsNullException;

public class Cash implements Account {
    Money rest;
    AccountType accountType;
    String name;
    String comments;
    Currency currency;

    public Cash(String name, AccountType accountType, Money rest,
            String comments) {
        setRest(rest);
        setAccountType(accountType);
        setName(name);
        setComments(comments);
    }

    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public String getComments() {
        return comments;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Money defineRest() {
        return rest;
    }

    public void setAccountType(AccountType accountType) {
        if (accountType == null) {
            throw new ArgumentIsNullException("accountType");
        }
        this.accountType = accountType;
    }

    @Override
    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setRest(Money rest) {
        if (rest == null) {
            throw new ArgumentIsNullException("rest");
        }
        this.rest = rest;
    }

    @Override
    public Currency getCurrency() {
        return this.currency;
    }

    @Override
    public void setCurrency(Currency currency) {
        if (currency == null) {
            throw new ArgumentIsNullException("currency");
        }
        this.currency = currency;
    }
}
