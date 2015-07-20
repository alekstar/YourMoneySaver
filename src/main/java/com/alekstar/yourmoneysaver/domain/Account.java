package com.alekstar.yourmoneysaver.domain;

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
}
