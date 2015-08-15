package com.alekstar.yourmoneysaver.domain.account;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alekstar.yourmoneysaver.domain.Currency;
import com.alekstar.yourmoneysaver.domain.exceptions.ArgumentIsNullException;
import com.alekstar.yourmoneysaver.domain.money.CommonMoney;

public class CashTest {
    private final Currency USD = new Currency(defineUSDName(),
            defineUsdIsoCode(), "$", null);
    private final Account pocket = new Cash(definePocketName(), USD, null);
    private final Account moneyBox = new Cash("Money box", USD, "My money box");

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
        assertEquals(CommonMoney.create("0", USD), pocket.defineRest());
    }

    @Test
    public void haveToBeNotClosed() {
        assertEquals(false, pocket.isClosed());
    }

    @Test
    public void haveToHaveTypeNameCash() {
        assertEquals("Cash", pocket.defineAccountTypeName());
    }

    @Test
    public void haveNotToHaveComments() {
        assertNull(pocket.getComments());
    }

    @Test
    public void haveToHaveSomeCommentsInComments() {
        final String SOME_COMMENTS = "Some comments";
        pocket.setComments(SOME_COMMENTS);
        assertEquals(SOME_COMMENTS, pocket.getComments());
    }

    @Test
    public void canSetNullToComments() {
        moneyBox.setComments(null);
        assertNull(pocket.getComments());
    }

    @Test
    public void haveCommentToBeMyMoneyBox() {
        assertEquals("My money box", moneyBox.getComments());
    }

    private String definePocketName() {
        return "Pocket";
    }

    private String defineUSDName() {
        return "US Dollar";
    }

    private String defineUsdIsoCode() {
        return "USD";
    }
}
