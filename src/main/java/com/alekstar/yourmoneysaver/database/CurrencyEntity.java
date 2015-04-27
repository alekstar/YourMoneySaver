package com.alekstar.yourmoneysaver.database;

public interface CurrencyEntity {
    void setName(String name);

    String getName();

    void setIsoCode(String isoCode);

    String getIsoCode();

    void setSymbol(String symbol);

    String getSymbol();

    void setComments(String comments);

    String getComments();
}
