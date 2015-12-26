package com.alekstar.yourmoneysaver.domain.account;

import com.alekstar.yourmoneysaver.domain.Currency;
import com.alekstar.yourmoneysaver.domain.money.CommonMoney;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

// TODO should return list of Operation

public class CashHistoryTest {
    Currency usd = new Currency("US Dollar", "USD", "$", null);
    Account pocket = new Cash("Pocket", usd, null);

    @Test
    public void shouldGetOperationsReturnListOfZeroOperations() throws Exception {
        assertEquals(0, pocket.getOperations().size());
    }

    @Test
    public void shouldGetOperationsReturnListOfOneOperationAfterPutting1Dollar() throws Exception {
        pocket.put(CommonMoney.create(1, usd));
        assertEquals(1, pocket.getOperations().size());
    }
}
