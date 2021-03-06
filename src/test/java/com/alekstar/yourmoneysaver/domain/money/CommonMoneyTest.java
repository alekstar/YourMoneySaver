package com.alekstar.yourmoneysaver.domain.money;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alekstar.yourmoneysaver.domain.Currency;
import com.alekstar.yourmoneysaver.domain.money.Money;

public class CommonMoneyTest {
    private final Currency USD = createCurrencyUSD();
    private final Currency EUR = createCurrencyEUR();

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

    @Test
    public void shouldGetDecimalPartMethodReturnStringObject() {
        Money money = createCommonMoneyFor45Point78USD();
        assertEquals(String.class, money.getDecimalPart().getClass());
    }

    @Test
    public void shouldGetDecimalReturn345Point78() {
        Money money = createCommonMoneyFor45Point78USD();
        final String DECIMAL_PART = "345.48";
        money.setDecimalPart(DECIMAL_PART);
        assertEquals(DECIMAL_PART, money.getDecimalPart());
    }

    @Test
    public void shouldGetDecimalReturn45Point78() {
        Money money = createCommonMoneyFor45Point78USD();
        assertEquals("45.78", money.getDecimalPart());
    }

    @Test
    public void shouldBeAddMethodWithMoneyParameter() {
        Money money1Point50USD = CommonMoney.create("1.50", USD);
        Money money123Point12USD = CommonMoney.create("123.12", USD);
        money1Point50USD.add(money123Point12USD);
    }

    @Test
    public void shouldAddMethodReturnCommonMoneyObject() {
        Money money1Point50USD = CommonMoney.create("1.50", USD);
        Money money123Point12USD = CommonMoney.create("123.12", USD);
        assertTrue(money123Point12USD.add(money1Point50USD) instanceof CommonMoney);
    }

    @Test
    public void shouldResultBe124Point62() {
        Money money1Point50USD = CommonMoney.create("1.50", USD);
        Money money123Point12USD = CommonMoney.create("123.12", USD);
        Money result = money123Point12USD.add(money1Point50USD);
        assertEquals("124.62", result.getDecimalPart());
    }

    @Test
    public void shouldResultBe36Point11() {
        Money money23Point99USD = CommonMoney.create("23.99", USD);
        Money money12Point12USD = CommonMoney.create("12.12", USD);
        Money result = money23Point99USD.add(money12Point12USD);
        assertEquals("36.11", result.getDecimalPart());
    }

    @Test
    public void shouldGetDecimalPartReturn2Point00() {
        Money money = CommonMoney.create("2", USD);
        assertEquals("2.00", money.getDecimalPart());
    }

    @Test
    public void shouldGetDecimalPartReturn3Point00() {
        Money money = CommonMoney.create("3.001", USD);
        assertEquals("3.00", money.getDecimalPart());
    }

    @Test
    public void shouldGetDecimalPartReturnMinus10Point23() {
        Money money = CommonMoney.create("-10.28", USD);
        assertEquals("-10.28", money.getDecimalPart());
    }

    @Test
    public void shouldResultBeMinus7Point33() {
        Money first = CommonMoney.create("-10.28", USD);
        Money second = CommonMoney.create("2.95", USD);
        Money result = first.add(second);
        assertEquals("-7.33", result.getDecimalPart());
    }

    @Test
    public void shouldResultBe3Point21() {
        Money first = CommonMoney.create("-2.79", USD);
        Money second = CommonMoney.create("6", USD);
        Money result = first.add(second);
        assertEquals("3.21", result.getDecimalPart());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAddMethodThrowIllegalArgumentException() {
        Money first = CommonMoney.create("5", USD);
        Money second =
                CommonMoney.create("5", new Currency("Ukrainian hryvnia",
                        "UAH", "₴", null));
        first.add(second);
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAddMethodThrowIllegalArgumentExceptionIfCurrenciesAreEqual() {
        Currency uah = new Currency("Ukrainian hryvnia", "UAH", "₴", null);
        Currency anotherUah =
                new Currency("Ukrainian hryvnia", "UAH", "₴", null);
        Money moneyWithUah = CommonMoney.create("5", uah);
        Money moneyWithAnotherUah = CommonMoney.create("7", anotherUah);
        moneyWithUah.add(moneyWithAnotherUah);
        fail();
    }

    @Test
    public void shouldResultHaveDecimalPart91Point56() {
        Money first = createCommonMoneyFor45Point78USD();
        Money result = first.add(first);
        assertEquals("91.56", result.getDecimalPart());
    }

    @Test
    public void shouldAddMethodDontChangeDecimalPartOfObject() {
        Money first = createCommonMoneyFor45Point78USD();
        String expected = first.getDecimalPart();
        first.add(first);
        assertEquals(expected, first.getDecimalPart());
    }

    @Test
    public void shouldAddMethodNotToChangeCurrencyOfObject() {
        Money first = createCommonMoneyFor45Point78USD();
        Currency expected = first.getCurrency();
        first.add(first);
        assertSame(expected, first.getCurrency());
    }

    @Test
    public void shouldHaveSubstractMethodWithOtherMoneyObject() {
        Money first = CommonMoney.create("11.11", USD);
        Money second = CommonMoney.create("12.12", USD);
        first.subtract(second);
    }

    @Test
    public void shouldSubstractMethodReturnMoneyObject() {
        Money first = CommonMoney.create("11.11", USD);
        Money second = CommonMoney.create("12.12", USD);
        @SuppressWarnings("unused")
        Money result = first.subtract(second);
    }

    @Test
    public void shouldSubstractMethodReturnCommonMoneyObject() {
        Money first = CommonMoney.create("11.11", USD);
        Money second = CommonMoney.create("12.12", USD);
        Money result = first.subtract(second);
        assertTrue(result instanceof CommonMoney);
    }

    @Test
    public void shouldResultBe2Point50() {
        Money first = CommonMoney.create("5.00", USD);
        Money second = CommonMoney.create("2.50", USD);
        Money result = first.subtract(second);
        assertEquals("2.50", result.getDecimalPart());
    }

    @Test
    public void shouldResultBeMinus5Point15() {
        Money first = CommonMoney.create("2.85", USD);
        Money second = CommonMoney.create("8.00", USD);
        Money result = first.subtract(second);
        assertEquals("-5.15", result.getDecimalPart());
    }

    @Test
    public void shouldResultBeUSD() {
        Money first = CommonMoney.create("5.00", USD);
        Money second = CommonMoney.create("2.50", USD);
        Money result = first.subtract(second);
        assertSame(USD, result.getCurrency());
    }

    @Test
    public void shouldResultBe$5Point00() {
        Money fiveDollars = CommonMoney.create("5.00", USD);
        assertEquals("$5.00", fiveDollars.defineStringRepresentation());
    }

    @Test
    public void shouldResultBe$45Point78() {
        Money money = createCommonMoneyFor45Point78USD();
        assertEquals("$45.78", money.defineStringRepresentation());
    }

    @Test
    public void shouldResultBeMinus$27Point50() {
        Money money = CommonMoney.create("-27.50", USD);
        assertEquals("-$27.50", money.defineStringRepresentation());
    }

    @Test
    public void shouldResultBe$0Point00() {
        Money money = CommonMoney.create("0", USD);
        assertEquals("$0.00", money.defineStringRepresentation());
    }

    @Test
    public void shouldCommonMoneyNotBeEqualToNull() {
        Money money = createCommonMoneyFor45Point78USD();
        assertFalse(money.equals(null));
    }

    @Test
    public void shouldCommonMoneyNotBeEqualToString() {
        assertFalse(createCommonMoneyFor45Point78USD().equals("45.78 USD"));
    }

    @Test
    public void oneDollarIsNotEqualsToZeroDollars() {
        Money oneDollar = CommonMoney.create("1", USD);
        Money zeroDollars = CommonMoney.create("0", USD);
        assertNotEquals(oneDollar, zeroDollars);
    }

    @Test
    public void shouldResultBe$1Point00() {
        Money money = CommonMoney.create(1, USD);
        assertEquals("$1.00", money.defineStringRepresentation());
    }

    @Test
    public void shouldResultBe3Point12Dollars() {
        Money money = CommonMoney.create(3.12, USD);
        assertEquals("$3.12", money.defineStringRepresentation());
    }

    @Test
    public void shouldOneDollarBeGreaterThanZeroDollars() {
        Money oneDollar = CommonMoney.create(1, USD);
        Money zeroDollars = CommonMoney.create(0, USD);
        assertTrue(CommonMoneyComparatorByDecimalPart.create().compare(oneDollar,
                zeroDollars) > 0);
    }

    @Test
    public void shouldNot2DollarsBeEqualTo2Euros() throws Exception {
        Money twoDollars = CommonMoney.create(2, USD);
        Money twoEuros = CommonMoney.create(2, EUR);
        assertNotEquals(twoDollars, twoEuros);
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

    private Currency createCurrencyEUR() { return new Currency("Euro", "EUR", "€", null);
    }
}
