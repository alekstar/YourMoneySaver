package com.alekstar.yourmoneysaver;

import java.util.List;

public interface CurrenciesContainer {
    void save(Currency currency);

    void remove(Currency currency);

    List<Currency> loadAll();
}
