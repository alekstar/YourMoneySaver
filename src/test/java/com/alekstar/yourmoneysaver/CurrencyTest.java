package com.alekstar.yourmoneysaver;

import static org.junit.Assert.*;

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

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenIsoCodeIs123() {
        @SuppressWarnings("unused")
        Currency currency = new Currency("Some currency", "123", "1", null);
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenIsoCodeIsuah() {
        @SuppressWarnings("unused")
        Currency currency = new Currency("Some currency", "uah", "1", null);
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenIsoCodeIsUA() {
        @SuppressWarnings("unused")
        Currency currency = new Currency("Some currency", "UA", "1", null);
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenIsoCodeIsUA1() {
        @SuppressWarnings("unused")
        Currency currency = new Currency("Some currency", "UA1", "1", null);
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenIsoCodeIsUAH1() {
        @SuppressWarnings("unused")
        Currency currency = new Currency("Some currency", "UAH1", "1", null);
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenIsoCodeIsNotEnglishLetters() {
        @SuppressWarnings("unused")
        Currency currency = new Currency("Some currency", "УКР", "1", null);
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSymbolHasMoreThan1Characters() {
        @SuppressWarnings("unused")
        Currency currency = new Currency("Some currency", "USD", "12", null);
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSymbolHasNoCharacters() {
        @SuppressWarnings("unused")
        Currency currency = new Currency("Some currency", "USD", "", null);
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSymbolIsNull() {
        @SuppressWarnings("unused")
        Currency currency = new Currency("Some currency", "USD", null, null);
        fail();
    }

    @Test
    public void shouldCreateCurrencyObjectWithNamesLengthIs50() {
        Currency currency =
                new Currency(
                        "The length of this string equals fifty characters.",
                        "USD", "$", null);
        assertEquals(50, currency.getName().length());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNamesLengthIs53() {
        @SuppressWarnings("unused")
        Currency currency =
                new Currency(
                        "The length of this string is fifty three characters!!",
                        "USD", "$", null);
        fail();
    }
}
