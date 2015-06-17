package com.alekstar.yourmoneysaver.money;

import com.alekstar.yourmoneysaver.Currency;

public interface Money {
    Currency getCurrency();

    void setCurrency(Currency currency);
}
