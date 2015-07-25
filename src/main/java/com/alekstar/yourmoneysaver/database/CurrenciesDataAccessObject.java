package com.alekstar.yourmoneysaver.database;

import java.util.List;

public interface CurrenciesDataAccessObject {
    void save(CurrencyEntity currency);

    void remove(CurrencyEntity currency);

    List<CurrencyEntity> loadAll();
}
