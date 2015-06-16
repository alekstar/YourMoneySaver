package com.alekstar.yourmoneysaver.money;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.alekstar.yourmoneysaver.Currency;

public class MoneyTest {
    @Test
    public void shouldCreateCommonMoneyObject() {
        Currency usd = new Currency("US Dollar", "USD", "$", null);
        Money money = CommonMoney.create("45.78", usd);
    }
}
