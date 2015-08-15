package com.alekstar.yourmoneysaver.domain.account;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alekstar.yourmoneysaver.domain.Currency;
import com.alekstar.yourmoneysaver.domain.exceptions.ArgumentIsNullException;
import com.alekstar.yourmoneysaver.domain.money.CommonMoney;

public class CashTest {
    private final Currency USD = new Currency("US Dollar", "USD", "$", null);
    private final Account pocket = new Cash("Pocket", USD, null);

    @Test
    public void haveGetNameReturnPocket() {
        assertEquals("Pocket", pocket.getName());
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
}
