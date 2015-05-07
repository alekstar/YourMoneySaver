package com.alekstar.yourmoneysaver.javafxui.currenciestab;

import java.util.List;

import com.alekstar.yourmoneysaver.database.CurrencyEntity;

public interface CurrenciesData {
    void save(CurrencyEntity currencyEntity);

    List<CurrencyEntity> getList();

    void remove(CurrencyEntity currencyEntity);
}
