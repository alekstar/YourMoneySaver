package com.alekstar.yourmoneysaver.money;

import org.junit.Test;

import com.alekstar.yourmoneysaver.Currency;

public class MoneyTest {
    @Test
    public void shouldCreateCommonMoneyObject() {
        Currency usd = new Currency("US Dollar", "USD", "$", null);
        @SuppressWarnings("unused")
        Money money = CommonMoney.create("45.78", usd);
    }
}
