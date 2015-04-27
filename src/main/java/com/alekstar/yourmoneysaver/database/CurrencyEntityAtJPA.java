package com.alekstar.yourmoneysaver.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.alekstar.yourmoneysaver.Currency;

@Entity
@Table(name = "Currencies")
public class CurrencyEntityAtJPA implements CurrencyEntity {
    public static final int NAME_MAX_STRING_LENGTH =
            Currency.NAME_MAX_STRING_LENGTH;
    public static final int ISO_CODE_STRING_LENGTH =
            Currency.ISO_CODE_STRING_LENGTH;
    public static final int SYMBOL_STRING_LENGTH =
            Currency.SYMBOL_STRING_LENGTH;
    public static final int COMMENTS_MAX_STRING_LENGTH =
            Currency.COMMENTS_MAX_STRING_LENGTH;

    @Transient
    private Currency currency;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(nullable = false, length = NAME_MAX_STRING_LENGTH)
    private String name;

    @Column(name = "iso_code", nullable = false, length = ISO_CODE_STRING_LENGTH)
    private String isoCode;

    @Column(nullable = false, length = SYMBOL_STRING_LENGTH)
    private String symbol;

    @Column(length = COMMENTS_MAX_STRING_LENGTH)
    private String comments;

    public CurrencyEntityAtJPA() {

    }

    public CurrencyEntityAtJPA(String name, String isoCode, String symbol,
            String comments) {
        this.name = name;
        this.isoCode = isoCode;
        this.symbol = symbol;
        this.comments = comments;
        createCurrency();
    }

    public CurrencyEntityAtJPA(Currency currency) {
        this(currency.getName(), currency.getIsoCode(), currency.getSymbol(),
                currency.getComments());
        createCurrency();
    }

    public Currency getCurrency() {
        return currency;
    }

    public long getId() {
        return id;
    }

    @Override
    public String getIsoCode() {
        return isoCode;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String getComments() {
        return comments;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
        refreshCurrency();
    }

    @Override
    public void setName(String name) {
        this.name = name;
        refreshCurrency();
    }

    @Override
    public void setSymbol(String symbol) {
        this.symbol = symbol;
        refreshCurrency();
    }

    @Override
    public void setComments(String comments) {
        this.comments = comments;
        refreshCurrency();
    }

    private void refreshCurrency() {
        currency =
                new Currency(getName(), getIsoCode(), getSymbol(),
                        getComments());
    }

    private void createCurrency() {
        refreshCurrency();
    }
}
