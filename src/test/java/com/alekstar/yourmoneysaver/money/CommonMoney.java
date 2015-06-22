package com.alekstar.yourmoneysaver.money;

import com.alekstar.yourmoneysaver.Currency;

public class CommonMoney implements Money {
    private Currency currency;
    private String decimalPart;

    protected CommonMoney(String decimalPart, Currency currency) {
        setCurrency(currency);
        setDecimalPart(decimalPart);
    }

    public static Money create(String decimalPart, Currency currency) {
        return new CommonMoney(decimalPart, currency);
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
        this.decimalPart = decimalPart;
    }

    @Override
    public String getDecimalPart() {
        return this.decimalPart;
    }

    private String defineExceptionTextWhenCurrencyIsNull() {
        return "Argument currency is null.";
    }

    @Override
    public void add(Money money) {

    }
}
