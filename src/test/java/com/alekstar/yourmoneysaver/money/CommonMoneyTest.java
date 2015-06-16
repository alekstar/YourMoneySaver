package com.alekstar.yourmoneysaver.money;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alekstar.yourmoneysaver.Currency;

public class CommonMoneyTest {
    private final Currency USD = new Currency("US Dollar", "USD", "$", null);

    @Test
    public void shouldCreateCommonMoneyObject() {
        @SuppressWarnings("unused")
        Money money = CommonMoney.create("45.78", USD);
    }

    @Test
    public void shouldCreateNotNullCommonMoneyObject() {
        Money money = CommonMoney.create("45.78", USD);
        assertNotNull(money);
    }

    @Test
    public void shouldHaveGetCurrencyMethod() {
        Money money = CommonMoney.create("45.78", USD);
        money.getCurrency();
    }
}
