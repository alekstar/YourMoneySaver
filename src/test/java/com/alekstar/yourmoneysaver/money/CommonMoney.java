package com.alekstar.yourmoneysaver.money;

import com.alekstar.yourmoneysaver.Currency;

public class CommonMoney implements Money {
    private Currency currency;

    protected CommonMoney(Currency currency) {
        this.currency = currency;
    }

    public static Money create(String decimalPart, Currency currency) {
        return new CommonMoney(currency);
    }

    @Override
    public Currency getCurrency() {
        return this.currency;
    }

    @Override
    public void setCurrency(Currency currency) {
        if (currency == null) {
            throw new IllegalArgumentException(defineExceptionTextWhenCurrencyIsNull());
        }
        this.currency = currency;
    }

    private String defineExceptionTextWhenCurrencyIsNull() {
        return "Argument currency is null.";
    }
}
