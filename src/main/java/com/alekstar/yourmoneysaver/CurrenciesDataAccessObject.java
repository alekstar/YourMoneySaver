package com.alekstar.yourmoneysaver;

import java.util.List;

public interface CurrenciesDataAccessObject {
    void save(Currency currency);

    void remove(Currency currency);

    List<Currency> loadAll();
}
