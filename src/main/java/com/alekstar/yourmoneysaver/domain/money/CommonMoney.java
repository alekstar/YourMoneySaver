package com.alekstar.yourmoneysaver.domain.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.alekstar.yourmoneysaver.domain.Currency;
import com.alekstar.yourmoneysaver.domain.money.Money;

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

    public static Money create(double decimalPart, Currency currency) {
        return new CommonMoney(new Double(decimalPart).toString(), currency);
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
        initializeDecimalPart(decimalPart);
    }

    private void initializeDecimalPart(String decimalPart) {
        this.decimalPart =
                new BigDecimal(decimalPart).setScale(defineScale(),
                        defineRoundingMode());
    }

    private RoundingMode defineRoundingMode() {
        return RoundingMode.HALF_EVEN;
    }

    private int defineScale() {
        return 2;
    }

    @Override
    public String getDecimalPart() {
        return this.decimalPart.toString();
    }

    private String defineExceptionTextWhenCurrencyIsNull() {
        return "Argument currency is null.";
    }

    private BigDecimal getDecimalPartInBigDecimal() {
        return this.decimalPart;
    }

    @Override
    public Money add(Money money) {
        if (money.getCurrency() != getCurrency()) {
            throw new IllegalArgumentException(
                    "To add money to other money they must have same "
                            + "currency.");
        }
        BigDecimal newDecimalPart =
                getDecimalPartInBigDecimal().add(
                        ((CommonMoney) money).getDecimalPartInBigDecimal());
        return create(newDecimalPart.toString(), getCurrency());
    }

    @Override
    public Money subtract(Money money) {
        BigDecimal newDecimalPart =
                getDecimalPartInBigDecimal().subtract(
                        ((CommonMoney) money).getDecimalPartInBigDecimal());
        return create(newDecimalPart.toString(), getCurrency());
    }

    @Override
    public String defineStringRepresentation() {
        StringBuilder stringBuilder = new StringBuilder();
        if (getDecimalPartInBigDecimal().compareTo(new BigDecimal("0")) >= 0) {
            stringBuilder.append(getCurrency().getSymbol());
            stringBuilder.append(getDecimalPart().toString());
        } else {
            stringBuilder.append('-');
            stringBuilder.append(getCurrency().getSymbol());
            stringBuilder.append(getDecimalPartInBigDecimal().abs().toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        if (obj instanceof Money) {
            Money anotherMoney = (Money) obj;
            if (!getDecimalPart().equals(anotherMoney.getDecimalPart())) {
                return false;
            }
            if(!getCurrency().equals(anotherMoney.getCurrency())) {
                return false;
            }
            return true;
        }
        return false;
    }
}
