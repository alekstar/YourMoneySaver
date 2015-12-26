package com.alekstar.yourmoneysaver.domain.account;

import com.alekstar.yourmoneysaver.domain.Currency;
import com.alekstar.yourmoneysaver.domain.money.Money;

import java.util.List;

public interface Account {
    String getName();

    void setName(String name);

    Currency getCurrency();

    void setCurrency(Currency currency);

    String getComments();

    void setComments(String comments);

    Money defineRest(Currency currency);

    Boolean isClosed();

    String defineAccountTypeName();

    void put(Money money);

    void get(double amount, Currency currency);

    List<String> getOperations();
}
