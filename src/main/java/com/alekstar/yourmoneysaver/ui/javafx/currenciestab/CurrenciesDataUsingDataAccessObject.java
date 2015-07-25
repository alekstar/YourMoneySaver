package com.alekstar.yourmoneysaver.ui.javafx.currenciestab;

import java.util.List;

import com.alekstar.yourmoneysaver.database.currency.CurrenciesDataAccessObject;
import com.alekstar.yourmoneysaver.database.currency.CurrencyEntity;

public class CurrenciesDataUsingDataAccessObject implements CurrenciesData {
    private final CurrenciesDataAccessObject currenciesDataAccessObject;
    private final List<CurrencyEntity> data;

    private CurrenciesDataUsingDataAccessObject(
            CurrenciesDataAccessObject currenciesDataAccessObject) {
        this.currenciesDataAccessObject = currenciesDataAccessObject;
        this.data = getCurrenciesDataAccessObject().loadAll();
    }

    public static CurrenciesDataUsingDataAccessObject create(
            CurrenciesDataAccessObject currenciesDataAccessObject) {
        return new CurrenciesDataUsingDataAccessObject(
                currenciesDataAccessObject);
    }

    public CurrenciesDataAccessObject getCurrenciesDataAccessObject() {
        return currenciesDataAccessObject;
    }

    @Override
    public void save(CurrencyEntity currencyEntity) {
        getCurrenciesDataAccessObject().save(currencyEntity);
        refreshData();
    }

    @Override
    public List<CurrencyEntity> getList() {
        return this.data;
    }

    @Override
    public void remove(CurrencyEntity currencyEntity) {
        getCurrenciesDataAccessObject().remove(currencyEntity);
        refreshData();
    }

    private void addDataFromBase() {
        getList().addAll(getCurrenciesDataAccessObject().loadAll());
    }

    private void clearData() {
        getList().clear();
    }

    private void refreshData() {
        clearData();
        addDataFromBase();
    }
}
