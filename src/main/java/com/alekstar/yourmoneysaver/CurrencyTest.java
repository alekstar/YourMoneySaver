package com.alekstar.yourmoneysaver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;

public class CurrencyTest {

    @Test
    public void shouldCreateCurrencyObjectWithNameEqualsUkrainianHrivnya() {
        Currency uah = new Currency("Ukrainian hrivnya", "UAH", "₴", null);
        assertEquals("Ukrainian hrivnya", uah.getName());
    }

    @Test
    public void shouldCreateCurrencyObjectWithIsoCodeEqualsUAH() {
        Currency uah = new Currency("Ukrainian hrivnya", "UAH", "₴", null);
        assertEquals("UAH", uah.getIsoCode());
    }

    @Test
    public void shouldCreateCurrencyObjectWithSymbolEquals₴() {
        Currency uah = new Currency("Ukrainian hrivnya", "UAH", "₴", null);
        assertEquals("₴", uah.getSymbol());
    }

    @Test
    public void shouldCreateCurrencyObjectWithEmptyComments() {
        Currency uah = new Currency("Ukrainian hrivnya", "UAH", "₴", null);
        assertEquals(null, uah.getComments());
    }

    @Test(expected = ArgumentIsNullException.class)
    public void shouldThrowExceptionWhenNameIsNull() {
        @SuppressWarnings("unused")
        Currency uah = new Currency(null, "UAH", "₴", null);
        fail();
    }
}
