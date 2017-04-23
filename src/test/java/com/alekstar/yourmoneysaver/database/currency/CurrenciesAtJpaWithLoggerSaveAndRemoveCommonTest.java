package com.alekstar.yourmoneysaver.database.currency;

import com.alekstar.yourmoneysaver.domain.Currency;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.MockitoAnnotations.initMocks;

public class CurrenciesAtJpaWithLoggerSaveAndRemoveCommonTest {

    private final RuntimeException exception;

    private final CurrencyEntityAtJpa currency;

    @Mock
    private Logger logger;

    @Mock
    private CurrenciesAtJpa currenciesAtJpa;

    @InjectMocks
    private CurrenciesDataAccessObject currenciesAtJpaWithLogger = new CurrenciesAtJpaWithLogger(currenciesAtJpa);

    private ExpectedException expectedException = ExpectedException.none();

    public CurrenciesAtJpaWithLoggerSaveAndRemoveCommonTest(CurrencyEntityAtJpa currency, RuntimeException exception) {
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

    public Logger getLogger() {
        return logger;
    }

    public CurrenciesAtJpa getCurrenciesAtJpa() {
        return currenciesAtJpa;
    }

    public CurrenciesDataAccessObject getCurrenciesAtJpaWithLogger() {
        return currenciesAtJpaWithLogger;
    }

    @Rule
    public ExpectedException getExpectedException() {
        return expectedException;
    }

    public CurrencyEntityAtJpa getCurrency() {
        return currency;
    }

    public RuntimeException getException() {
        return exception;
    }
}
