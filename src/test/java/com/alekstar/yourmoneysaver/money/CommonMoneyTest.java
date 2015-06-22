package com.alekstar.yourmoneysaver.money;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alekstar.yourmoneysaver.Currency;

public class CommonMoneyTest {
    @Test
    public void shouldCreateCommonMoneyObject() {
        createCommonMoneyFor45Point78USD();
    }

    @Test
    public void shouldCreateNotNullCommonMoneyObject() {
        Money money = createCommonMoneyFor45Point78USD();
        assertNotNull(money);
    }

    @Test
    public void shouldHaveGetCurrencyMethod() {
        Money money = createCommonMoneyFor45Point78USD();
        money.getCurrency();
    }

    @Test
    public void shouldGetCurrencyReturnCurrencyObject() {
        Money money = createCommonMoneyFor45Point78USD();
        assertTrue(money.getCurrency() instanceof Currency);
    }

    @Test
    public void shouldCreateMethodReturnCommonMoneyObject() {
        Money money = createCommonMoneyFor45Point78USD();
        assertTrue(money instanceof CommonMoney);
    }

    @Test
    public void shouldGetCurrencyMethodReturnThatCurrencyWhichWasPassedThroughCreateMethod() {
        Currency usd = createCurrencyUSD();
        Money money = CommonMoney.create("45.78", usd);
        assertTrue(usd == money.getCurrency());
    }

    @Test
    public void shouldSetCurrencyChangeCurrencyWhichIsAtCommonMoneyObject() {
        Money money = createCommonMoneyFor45Point78USD();
        Currency uah = new Currency("Ukrainian hrivnya", "UAH", "₴", null);
        money.setCurrency(uah);
        assertSame(uah, money.getCurrency());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldSetCurrencyThrowIllegalArgumentException() {
        Money money = createCommonMoneyFor45Point78USD();
        money.setCurrency(null);
        fail();
    }

    @Test
    public void shouldSetCurrencyThrowIllegalArgumentExceptionWithInformationAboutWrongArgument() {
        Money money = createCommonMoneyFor45Point78USD();
        try {
            money.setCurrency(null);
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().contentEquals(
                    defineExceptionTextWhenCurrencyIsNull())) {
                fail();
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldCreateMethodThrowIllegalArgumentException() {
        CommonMoney.create("45.78", null);
        fail();
    }

    @Test
    public void shouldBeSetDecimalPartMethod() {
        Money money = createCommonMoneyFor45Point78USD();
        money.setDecimalPart("45.78");
    }

    @Test
    public void shouldBeGetDecimalPartMethod() {
        Money money = createCommonMoneyFor45Point78USD();
        money.getDecimalPart();
    }
    private String defineExceptionTextWhenCurrencyIsNull() {
        return "Argument currency is null.";
    }

    private Money createCommonMoneyFor45Point78USD() {
        return CommonMoney.create("45.78", createCurrencyUSD());
    }

    private Currency createCurrencyUSD() {
        return new Currency("US Dollar", "USD", "$", null);
    }
}
