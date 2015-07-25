package com.alekstar.yourmoneysaver.domain.account;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alekstar.yourmoneysaver.domain.Currency;

public class CashTest {
    Account pocket = new Cash("Pocket", new Currency("US Dollar", "USD", "$",
            null), null);

    @Test
    public void haveGetNameReturnPocket() {
        assertEquals("Pocket", pocket.getName());
    }

    @Test
    public void haveSetNameChangeNameToMyPocket() {
        pocket.setName("My Pocket");
        assertEquals("My Pocket", pocket.getName());
    }
}
