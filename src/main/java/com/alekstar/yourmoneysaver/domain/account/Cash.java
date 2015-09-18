package com.alekstar.yourmoneysaver.domain.account;

import com.alekstar.yourmoneysaver.domain.Currency;
import com.alekstar.yourmoneysaver.domain.exceptions.ArgumentIsNullException;
import com.alekstar.yourmoneysaver.domain.money.CommonMoney;
import com.alekstar.yourmoneysaver.domain.money.Money;

public class Cash implements Account {
    String name;
    String comments;
    Currency currency;
    Money rest;

    public Cash(String name, Currency currency, String comments) {
        setName(name);
        setCurrency(currency);
        setRest(CommonMoney.create("0", currency));
        setComments(comments);
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
    public Money defineRest(Currency currency) {
        // TODO calculate operations' sums
        return this.rest;
    }

    @Override
    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public void setName(String name) {
        if (name == null) {
            throw new ArgumentIsNullException("name");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty.");
        }
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

    @Override
    public void put(Money money) {
        setRest(getRest().add(money));
    }

    @Override
    public void get(String amount, Currency currency) {

    }

    private Money getRest() {
        return rest;
    }

    private void setRest(Money rest) {
        this.rest = rest;
    }
}
