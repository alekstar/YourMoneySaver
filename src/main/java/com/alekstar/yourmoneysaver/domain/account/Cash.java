package com.alekstar.yourmoneysaver.domain.account;

import com.alekstar.yourmoneysaver.domain.AccountType;
import com.alekstar.yourmoneysaver.domain.Currency;
import com.alekstar.yourmoneysaver.domain.exceptions.ArgumentIsNullException;
import com.alekstar.yourmoneysaver.domain.money.CommonMoney;
import com.alekstar.yourmoneysaver.domain.money.Money;

public class Cash implements Account {
    AccountType accountType;
    String name;
    String comments;
    Currency currency;

    public Cash(String name, AccountType accountType, Currency currency,
            String comments) {
        setAccountType(accountType);
        setName(name);
        setCurrency(currency);
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
        // TODO calculate operations' sums
        return CommonMoney.create("0", getCurrency());
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

    @Override
    public Boolean isClosed() {
        // TODO if account have last operation of closing account then true,
        // else false
        return new Boolean(false);
    }

    @Override
    public String defineAccountTypeName() {
        return "Cash";
    }
}
