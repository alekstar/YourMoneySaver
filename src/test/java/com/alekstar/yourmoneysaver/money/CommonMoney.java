package com.alekstar.yourmoneysaver.money;

import com.alekstar.yourmoneysaver.Currency;

public class CommonMoney implements Money {
    private Currency currency;

    protected CommonMoney(Currency currency) {
        setCurrency(currency);
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
            throw new IllegalArgumentException(
                    defineExceptionTextWhenCurrencyIsNull());
        }
        this.currency = currency;
    }

    @Override
    public void setDecimalPart(String decimalPart) {
    }

    @Override
    public void getDecimalPart() {
    }

    private String defineExceptionTextWhenCurrencyIsNull() {
        return "Argument currency is null.";
    }
}
