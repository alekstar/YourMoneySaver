package com.alekstar.yourmoneysaver.domain;

import java.util.List;

import com.alekstar.yourmoneysaver.database.CurrencyEntity;

public interface CurrenciesDataAccessObject {
    void save(CurrencyEntity currency);

    void remove(CurrencyEntity currency);

    List<CurrencyEntity> loadAll();
}
