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

    private Currency currency;
    private long id;

    public CurrencyEntityAtJPA() {
        setCurrency(new Currency("Invalid currency", "INV", "I", null));
    }

    public CurrencyEntityAtJPA(String name, String isoCode, String symbol,
            String comments) {
        setCurrency(new Currency(name, isoCode, symbol, comments));
    }

    public CurrencyEntityAtJPA(Currency currency) {
        this(currency.getName(), currency.getIsoCode(), currency.getSymbol(),
                currency.getComments());
    }

    @Transient
    public Currency getCurrency() {
        return currency;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public long getId() {
        return id;
    }

    @Override
    @Column(name = "iso_code", nullable = false, length = ISO_CODE_STRING_LENGTH)
    public String getIsoCode() {
        return getCurrency().getIsoCode();
    }

    @Override
    @Column(name = "name", nullable = false, length = NAME_MAX_STRING_LENGTH)
    public String getName() {
        return getCurrency().getName();
    }

    @Override
    @Column(name = "symbol", nullable = false, length = SYMBOL_STRING_LENGTH)
    public String getSymbol() {
        return getCurrency().getSymbol();
    }

    @Override
    @Column(name = "comments", nullable = true, length = COMMENTS_MAX_STRING_LENGTH)
    public String getComments() {
        return getCurrency().getComments();
    }

    private void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void setIsoCode(String isoCode) {
        getCurrency().setIsoCode(isoCode);
    }

    @Override
    public void setName(String name) {
        getCurrency().setName(name);
    }

    @Override
    public void setSymbol(String symbol) {
        getCurrency().setSymbol(symbol);
    }

    @Override
    public void setComments(String comments) {
        getCurrency().setComments(comments);
    }

    @Override
    public int hashCode() {
        return getCurrency().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CurrencyEntityAtJPA)) {
            throw new IllegalArgumentException(obj.toString()
                    + " is not CurrencyEntityAtJPA object.");
        }
        return getCurrency().equals(((CurrencyEntityAtJPA) obj).getCurrency());
    }
}
