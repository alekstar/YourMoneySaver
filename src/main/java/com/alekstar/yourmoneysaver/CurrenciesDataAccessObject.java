package com.alekstar.yourmoneysaver;

import java.util.List;

import com.alekstar.yourmoneysaver.database.CurrencyEntity;

public interface CurrenciesDataAccessObject {
    void save(CurrencyEntity currency);

    void remove(CurrencyEntity currency);

    List<CurrencyEntity> loadAll();
}
