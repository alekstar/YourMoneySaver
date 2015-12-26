package com.alekstar.yourmoneysaver.domain.account;

import com.alekstar.yourmoneysaver.domain.Currency;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CashHistoryTest {
    Currency usd = new Currency("US Dollar", "USD", "$", null);
    Account pocket = new Cash("Pocket", usd, null);

    @Test
    public void shouldGetOperationsReturnListOfZeroOperations() throws Exception {
        assertEquals(0, pocket.getOperations().size());
    }
}
