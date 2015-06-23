package com.alekstar.yourmoneysaver.money;

import java.math.BigDecimal;

import com.alekstar.yourmoneysaver.Currency;

public class CommonMoney implements Money {
    private Currency currency;
    private BigDecimal decimalPart;

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
        this.decimalPart = new BigDecimal(decimalPart);
    }

    @Override
    public String getDecimalPart() {
        return this.decimalPart.toString();
    }

    private String defineExceptionTextWhenCurrencyIsNull() {
        return "Argument currency is null.";
    }

    @Override
    public Money add(Money money) {
        BigDecimal newDecimalPart =
                this.decimalPart.add(((CommonMoney) money).decimalPart);
        return create(newDecimalPart.toString(), getCurrency());
    }
}
