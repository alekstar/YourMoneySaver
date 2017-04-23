package com.alekstar.yourmoneysaver.database.currency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class CurrenciesAtJpaWithLoggerSaveTest extends CurrenciesAtJpaWithLoggerSaveAndRemoveCommonTest {

    public CurrenciesAtJpaWithLoggerSaveTest(CurrencyEntityAtJpa currency, RuntimeException exception) {
        super(currency, exception);
    }

    @Test
    public void shouldCallDebugOnLoggerWithSavingCurrency() {
        save();
        verify(getLogger(), times(1)).debug("Saving currency " + getCurrency());
    }

    @Test
    public void shouldCallSaveOfCurrenciesAtJpaWithSpecifiedCurrency() {
        save();
        verify(getCurrenciesAtJpa(), times(1)).save(getCurrency());
    }

    @Test
    public void shouldCallDebugOnLoggerWithCurrencySaved() {
        save();
        verify(getLogger(), times(1)).debug("Currency " + getCurrency() + " saved.");
    }

    @Test
    public void shouldCallDebugOnLoggerWithCurrencySavedAfterSaveMethodCalled() {
        save();
        final InOrder inOrder = inOrder(getCurrenciesAtJpa(), getLogger());
        inOrder.verify(getCurrenciesAtJpa()).save(getCurrency());
        inOrder.verify(getLogger()).debug("Currency " + getCurrency() + " saved.");
    }

    @Test
    public void shouldCallErrorOnLoggerWithCurrencyHaveNotBeenSavedBecauseOfException() {
        doThrow(getException()).when(getCurrenciesAtJpa()).save(getCurrency());
        getExpectedException().expect(getException().getClass());
        save();
        final String message = "Currency " + getCurrency() + " have not been saved because of exception.";
        verify(getLogger(), times(1)).error(message, getException());
    }

    private void save() {
        getCurrenciesAtJpaWithLogger().save(getCurrency());
    }
}