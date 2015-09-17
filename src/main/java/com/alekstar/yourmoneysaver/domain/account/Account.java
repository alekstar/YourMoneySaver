package com.alekstar.yourmoneysaver.domain.account;

import com.alekstar.yourmoneysaver.domain.Currency;
import com.alekstar.yourmoneysaver.domain.money.Money;

public interface Account {
    String getName();

    void setName(String name);

    Currency getCurrency();

    void setCurrency(Currency currency);

    String getComments();

    void setComments(String comments);

    Money defineRest();

    Boolean isClosed();

    String defineAccountTypeName();

    void put(Money money);

    void get(String amount, Currency currency);
}
