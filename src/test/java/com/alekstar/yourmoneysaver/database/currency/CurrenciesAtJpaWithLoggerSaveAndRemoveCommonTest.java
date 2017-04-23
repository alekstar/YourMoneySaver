package com.alekstar.yourmoneysaver.database.currency;

import com.alekstar.yourmoneysaver.domain.Currency;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class CurrenciesAtJpaWithLoggerSaveAndRemoveCommonTest extends CurrenciesAtJpaWithLoggerCommonTest {

    private final CurrencyEntityAtJpa currency;

    CurrenciesAtJpaWithLoggerSaveAndRemoveCommonTest(CurrencyEntityAtJpa currency, RuntimeException exception) {
        super(exception);
        this.currency = currency;
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

    public CurrencyEntityAtJpa getCurrency() {
        return currency;
    }

}
