package com.alekstar.yourmoneysaver;

import java.util.TreeSet;

import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;

public class CurrenciesContainer {
    TreeSet<Currency> currencies;

    protected CurrenciesContainer() {
        setCurrencies(new TreeSet<Currency>());
    }

    public static CurrenciesContainer create() {
        return new CurrenciesContainer();
    }

    private void setCurrencies(TreeSet<Currency> currencies) {
        if (currencies == null) {
            throw new ArgumentIsNullException("currencies");
        }
        this.currencies = currencies;
    }

    public void add(Currency currency) {
        verifyCurrencies();
        currencies.add(currency);
    }

    private void verifyCurrencies() {
        if (currencies == null) {
            throw new IllegalStateException(
                    "Reference to list of currencies is null.");
        }
    }

    public TreeSet<Currency> getCurrencies() {
        return this.currencies;
    }

    public void delete(Currency currency) {
        currencies.remove(currency);
    }
}
