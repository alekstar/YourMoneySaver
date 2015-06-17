package com.alekstar.yourmoneysaver.money;

import com.alekstar.yourmoneysaver.Currency;

public class CommonMoney implements Money {

    public static Money create(String decimalPart, Currency currency) {
        return new CommonMoney();
    }

    @Override
    public Currency getCurrency() {
        return new Currency("name", "ISO", "i", "comments");
    }
}
