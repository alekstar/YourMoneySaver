package com.alekstar.yourmoneysaver.database.currency;

import com.alekstar.yourmoneysaver.domain.Currency;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(Parameterized.class)
public class CurrenciesAtJpaWithLoggerSaveTest {

    @Mock
    private Logger logger;

    @Mock
    private CurrenciesAtJpa currenciesAtJpa;

    @InjectMocks
    private CurrenciesDataAccessObject currenciesAtJpaWithLogger = new CurrenciesAtJpaWithLogger(currenciesAtJpa);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final CurrencyEntityAtJpa currency;
    private final RuntimeException exception;

    public CurrenciesAtJpaWithLoggerSaveTest(CurrencyEntityAtJpa currency, RuntimeException exception) {
        this.currency = currency;
        this.exception = exception;
    }

    @Parameterized.Parameters(name = "Currency: {0}, Exception: {1}")
    public static Collection<Object[]> defineParameters() {
        return Arrays.asList(new Object[][]{
                {new CurrencyEntityAtJpa(
                        new Currency("Some name", "SON", "S", null)),
                        new RuntimeException("Runtime exception")},
                {new CurrencyEntityAtJpa(
                        new Currency("Another name", "ANN", "A", null)),
                        new IllegalArgumentException("Illegal argument exception")}
        });
    }

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void shouldCallDebugOnLoggerWithSavingCurrency() {
        save();
        verify(logger, times(1)).debug("Saving currency " + currency);
    }

    @Test
    public void shouldCallSaveOfCurrenciesAtJpaWithSpecifiedCurrency() {
        save();
        verify(currenciesAtJpa, times(1)).save(currency);
    }

    @Test
    public void shouldCallDebugOnLoggerWithCurrencySaved() {
        save();
        verify(logger, times(1)).debug("Currency " + currency + " saved.");
    }

    @Test
    public void shouldCallDebugOnLoggerWithCurrencySavedAfterSaveMethodCalled() {
        save();
        final InOrder inOrder = inOrder(currenciesAtJpa, logger);
        inOrder.verify(currenciesAtJpa).save(currency);
        inOrder.verify(logger).debug("Currency " + currency + " saved.");
    }

    @Test
    public void shouldCallErrorOnLoggerWithCurrencyHaveNotBeenSavedBecauseOfException() {
        doThrow(exception).when(currenciesAtJpa).save(currency);
        expectedException.expect(exception.getClass());
        save();
        final String message = "Currency " + currency + " have not been saved because of exception.";
        verify(logger, times(1)).error(message, exception);
    }

    private void save() {
        currenciesAtJpaWithLogger.save(currency);
    }
}