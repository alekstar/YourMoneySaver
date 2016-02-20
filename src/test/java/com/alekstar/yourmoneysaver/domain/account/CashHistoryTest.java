package com.alekstar.yourmoneysaver.domain.account;

import com.alekstar.yourmoneysaver.domain.Currency;
import com.alekstar.yourmoneysaver.domain.Operation;
import com.alekstar.yourmoneysaver.domain.money.CommonMoney;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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

    @Test
    public void shouldGetOperationsReturnListOfTwoOperationsAfterPutting1DollarTwice() throws Exception {
        pocket.put(CommonMoney.create(1, usd));
        pocket.put(CommonMoney.create(1, usd));
        assertThat(pocket.getOperations().size(), is(2));
    }

    @Test
    public void shouldGetOperationsReturnListOfOperations() throws Exception {
        pocket.put(CommonMoney.create(1, usd));
        assertThat(pocket.getOperations().get(0) instanceof Operation, is(true));
    }
}
