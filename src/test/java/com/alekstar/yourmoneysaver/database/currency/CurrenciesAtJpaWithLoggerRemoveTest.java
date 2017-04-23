package com.alekstar.yourmoneysaver.database.currency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(Parameterized.class)
public class CurrenciesAtJpaWithLoggerRemoveTest extends CurrenciesAtJpaWithLoggerSaveAndRemoveCommonTest {

    public CurrenciesAtJpaWithLoggerRemoveTest(CurrencyEntityAtJpa currency, RuntimeException exception) {
        super(exception, currency);
    }

    @Test
    public void shouldCallDebugOnLoggerWithRemovingCurrency() {
        remove();
        verify(getLogger(), times(1)).debug("Removing currency " + getCurrency());
    }

    @Test
    public void shouldCallRemoveOfCurrenciesAtJpaWithSpecifiedCurrency() {
        remove();
        verify(getCurrenciesAtJpa(), times(1)).remove(getCurrency());
    }

    @Test
    public void shouldCallDebugOnLoggerWithCurrencyRemoved() {
        remove();
        verify(getLogger(), times(1)).debug("Currency " + getCurrency() + " have been removed.");
    }

    @Test
    public void shouldCallDebugOnLoggerWithCurrencyRemovedAfterSaveMethodCalled() {
        remove();
        final InOrder inOrder = inOrder(getCurrenciesAtJpa(), getLogger());
        inOrder.verify(getCurrenciesAtJpa()).remove(getCurrency());
        inOrder.verify(getLogger()).debug("Currency " + getCurrency() + " have been removed.");
    }

    @Test
    public void shouldCallErrorOnLoggerWithCurrencyHaveNotBeenSavedBecauseOfException() {
        doThrow(getException()).when(getCurrenciesAtJpa()).remove(getCurrency());
        getExpectedException().expect(getException().getClass());
        remove();
        final String message = "Currency " + getCurrency() + " have not been removed because of exception.";
        verify(getLogger(), times(1)).error(message, getException());
    }

    private void remove() {
        getCurrenciesAtJpaWithLogger().remove(getCurrency());
    }
}