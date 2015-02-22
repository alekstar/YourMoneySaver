package com.yourmoneysaver;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yourmoneysaver.Currency;
import com.yourmoneysaver.Money;

public class MoneyTest {

	@Test
	public void testAdd() {
		Currency currency = new Currency("Гривны", "980");
		Money first = new Money(currency, 56, 54);
		Money second = new Money(currency, 57, 57);
		Money result = first.add(second);
		assertEquals(currency, first.getCurrency());
		assertEquals(56, first.getBase());
		assertEquals(54, first.getCoins());
		assertEquals(Money.getDefaultCoinsDigitsNumber(),
		        first.getCoinsDigitsNumber());
		assertEquals(Money.getDefaultCoinsDigitsNumber(),
		        first.getCoinsDigitsNumber());
		assertEquals(currency, second.getCurrency());
		assertEquals(57, second.getBase());
		assertEquals(57, second.getCoins());
		assertEquals(Money.getDefaultCoinsDigitsNumber(),
		        second.getCoinsDigitsNumber());
		assertEquals(Money.getDefaultCoinsDigitsNumber(),
		        second.getCoinsDigitsNumber());
		assertEquals(currency, result.getCurrency());
		assertEquals(114, result.getBase());
		assertEquals(11, result.getCoins());
		assertEquals(Money.getDefaultCoinsDigitsNumber(),
		        result.getCoinsDigitsNumber());
		assertEquals(Money.getDefaultCoinsDigitsNumber(),
		        result.getCoinsDigitsNumber());
	}

	@Test
	public void testSubstract() {
		Currency currency = new Currency("Гривны", "980");
		Money first = new Money(currency, 105, 5);
		Money second = new Money(currency, 7, 57);
		Money result = first.substract(second);
		assertEquals(currency, first.getCurrency());
		assertEquals(105, first.getBase());
		assertEquals(5, first.getCoins());
		assertEquals(Money.getDefaultCoinsDigitsNumber(),
		        first.getCoinsDigitsNumber());
		assertEquals(Money.getDefaultCoinsDigitsNumber(),
		        first.getCoinsDigitsNumber());
		assertEquals(currency, second.getCurrency());
		assertEquals(7, second.getBase());
		assertEquals(57, second.getCoins());
		assertEquals(Money.getDefaultCoinsDigitsNumber(),
		        second.getCoinsDigitsNumber());
		assertEquals(Money.getDefaultCoinsDigitsNumber(),
		        second.getCoinsDigitsNumber());
		assertEquals(currency, result.getCurrency());
		assertEquals(97, result.getBase());
		assertEquals(48, result.getCoins());
		assertEquals(Money.getDefaultCoinsDigitsNumber(),
		        result.getCoinsDigitsNumber());
		assertEquals(Money.getDefaultCoinsDigitsNumber(),
		        result.getCoinsDigitsNumber());
	}

}
