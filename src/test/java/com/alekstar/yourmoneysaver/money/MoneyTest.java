package com.alekstar.yourmoneysaver.money;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alekstar.yourmoneysaver.Currency;

public class MoneyTest {
    @Test
    public void shouldCreateCommonMoneyObject() {
        Currency usd = new Currency("US Dollar", "USD", "$", null);
        @SuppressWarnings("unused")
        Money money = CommonMoney.create("45.78", usd);
    }

    @Test
    public void shouldCreateNotNullCommonMoneyObject() {
        Currency usd = new Currency("US Dollar", "USD", "$", null);
        Money money = CommonMoney.create("45.78", usd);
        assertNotNull(money);
    }
}
