package com.alekstar.yourmoneysaver.domain;

public interface Account {
    String getName();

    void setName(String name);

    Currency getCurrency();

    void setCurrency(Currency currency);

    String getComments();

    void setComments(String comments);
}
