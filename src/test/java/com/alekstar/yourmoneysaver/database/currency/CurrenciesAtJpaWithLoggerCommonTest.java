package com.alekstar.yourmoneysaver.database.currency;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.initMocks;

public class CurrenciesAtJpaWithLoggerCommonTest {

    private final RuntimeException exception;

    @Mock
    private Logger logger;

    @Mock
    private CurrenciesAtJpa currenciesAtJpa;

    @InjectMocks
    private CurrenciesDataAccessObject currenciesAtJpaWithLogger = new CurrenciesAtJpaWithLogger(currenciesAtJpa);

    private ExpectedException expectedException = ExpectedException.none();

    CurrenciesAtJpaWithLoggerCommonTest(RuntimeException exception) {
        this.exception = exception;
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

    public RuntimeException getException() {
        return exception;
    }
}
