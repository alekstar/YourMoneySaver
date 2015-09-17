package com.alekstar.yourmoneysaver.domain.account;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alekstar.yourmoneysaver.domain.Currency;
import com.alekstar.yourmoneysaver.domain.exceptions.ArgumentIsNullException;
import com.alekstar.yourmoneysaver.domain.money.CommonMoney;
import com.alekstar.yourmoneysaver.domain.money.Money;

public class CashTest {
    private final Currency usd = new Currency(defineUsdName(),
            defineUsdIsoCode(), defineUsdSymbol(), null);
    private final Currency eur = new Currency("Euro", "EUR", "€", null);
    private final Account pocket = new Cash(definePocketName(), usd, null);
    private final Account moneyBox = new Cash(defineMoneyBoxName(), usd,
            defineMoneyBoxComments());

    @Test
    public void haveGetNameReturnPocket() {
        assertEquals(definePocketName(), pocket.getName());
    }

    @Test
    public void haveSetNameChangeNameToMyPocket() {
        pocket.setName("My Pocket");
        assertEquals("My Pocket", pocket.getName());
    }

    @Test(expected = ArgumentIsNullException.class)
    public void haveToThrowExceptionIfNameIsNull() {
        pocket.setName(null);
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void haveToThrowExceptionIfNameIsEmpty() {
        pocket.setName("");
        fail();
    }

    @Test
    public void haveToDefineRestReturn0OfUSD() {
        assertEquals(CommonMoney.create("0", usd), pocket.defineRest());
    }

    @Test
    public void haveToBeNotClosed() {
        assertEquals(false, pocket.isClosed());
    }

    @Test
    public void haveToHaveTypeNameCash() {
        assertEquals(defineCashAccountTypeName(),
                pocket.defineAccountTypeName());
    }

    @Test
    public void haveNotToHaveComments() {
        assertNull(pocket.getComments());
    }

    @Test
    public void haveToHaveSomeCommentsInComments() {
        final String someComments = "Some comments";
        pocket.setComments(someComments);
        assertEquals(someComments, pocket.getComments());
    }

    @Test
    public void canSetNullToComments() {
        moneyBox.setComments(null);
        assertNull(pocket.getComments());
    }

    @Test
    public void haveCommentToBeMyMoneyBox() {
        assertEquals(defineMoneyBoxComments(), moneyBox.getComments());
    }

    @Test
    public void canChangeCurrency() {
        pocket.setCurrency(eur);
        assertEquals(eur, pocket.getCurrency());
    }

    @Test(expected = ArgumentIsNullException.class)
    public void cantChangeCurrencyToNull() {
        pocket.setCurrency(null);
        fail();
    }

    @Test
    public void haveToSetReferenceToCurrencyWhichWasSet() {
        pocket.setCurrency(eur);
        assertSame(eur, pocket.getCurrency());
    }

    @Test
    public void canPutMoneyToPocket() {
        Money someMoney = CommonMoney.create("1", usd);
        pocket.put(someMoney);
    }

    private String definePocketName() {
        return "Pocket";
    }

    private String defineUsdName() {
        return "US Dollar";
    }

    private String defineUsdIsoCode() {
        return "USD";
    }

    private String defineUsdSymbol() {
        return "$";
    }

    private String defineMoneyBoxComments() {
        return "My money box";
    }

    private String defineMoneyBoxName() {
        return "Money box";
    }

    private String defineCashAccountTypeName() {
        return "Cash";
    }
}
