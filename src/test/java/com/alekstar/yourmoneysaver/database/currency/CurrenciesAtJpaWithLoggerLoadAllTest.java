package com.alekstar.yourmoneysaver.database.currency;

import com.alekstar.yourmoneysaver.domain.Currency;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InOrder;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class CurrenciesAtJpaWithLoggerLoadAllTest extends CurrenciesAtJpaWithLoggerCommonTest {

    private final List<CurrencyEntity> currenciesInDatabase;

    public CurrenciesAtJpaWithLoggerLoadAllTest(List<CurrencyEntity> currenciesInDatabase,
                                                RuntimeException exception) {
        super(exception);
        this.currenciesInDatabase = currenciesInDatabase;
    }

    @Parameterized.Parameters(name = "Currencies in database: {0}, Exception: {1}")
    public static Collection<Object[]> defineParameters() {
        return Arrays.asList(new Object[][]{
                {Collections.singletonList(new CurrencyEntityAtJpa(
                        new Currency("Some name", "SON", "S", null))),
                        new RuntimeException("Runtime exception")},
                {Collections.singletonList(new CurrencyEntityAtJpa(
                        new Currency("Another name", "ANN", "A", null))),
                        new IllegalArgumentException("Illegal argument exception")}
        });
    }

    @Override
    @Before
    public void setUp() {
        super.setUp();
        when(getCurrenciesAtJpa().loadAll()).thenReturn(currenciesInDatabase);
    }

    @Test
    public void shouldCallLoadAllMethodOfCurrenciesAtJpa() {
        loadAll();
        verify(getCurrenciesAtJpa()).loadAll();
    }

    @Test
    public void shouldCallDebugLoadingAllCurrenciesOnCallingLoadAll() {
        loadAll();
        verify(getLogger()).debug("Loading all currencies.");
    }

    @Test
    public void shouldCallDebugLoadingAllCurrenciesBeforeCallingLoadAll() {
        loadAll();
        final InOrder inOrder = inOrder(getCurrenciesAtJpa(), getLogger());
        inOrder.verify(getLogger()).debug("Loading all currencies.");
        inOrder.verify(getCurrenciesAtJpa()).loadAll();
    }

    @Test
    public void shouldCallDebugLoadedCurrenciesOnCallingLoadAll() {
        loadAll();
        verify(getLogger()).debug("Loaded currencies: " + getCurrenciesInDatabase());
    }

    @Test
    public void shouldReturnTheValueFromCurrenciesAtJpaLoadAllMethod() {
        final List<CurrencyEntity> currencies = loadAll();
        assertThat(currencies, is(getCurrenciesInDatabase()));
    }

    private List<CurrencyEntity> loadAll() {
        return getCurrenciesAtJpaWithLogger().loadAll();
    }

    public List<CurrencyEntity> getCurrenciesInDatabase() {
        return currenciesInDatabase;
    }
}
