package com.alekstar.yourmoneysaver.domain.money;

import com.alekstar.yourmoneysaver.domain.Currency;

public interface Money {
    Currency getCurrency();

    void setCurrency(Currency currency);

    void setDecimalPart(String decimalPart);

    String getDecimalPart();

    Money add(Money money);

    Money subtract(Money second);

    String defineStringRepresentation();
}
